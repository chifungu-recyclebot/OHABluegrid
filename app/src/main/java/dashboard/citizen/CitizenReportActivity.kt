package dashboard.citizen

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabel
import com.google.mlkit.vision.label.ImageLabeler
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions
import com.greenway.ohabluegrid.databinding.FragmentCitizenReportBinding

class CitizenReportActivity : Fragment() {

    private val requestImageCapture = 1

    private lateinit var binding: FragmentCitizenReportBinding
    private lateinit var issueImageView: ImageView
    private lateinit var captureImageButton: Button
    private lateinit var issueTypeSpinner: Spinner
    private lateinit var submitReportButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCitizenReportBinding.inflate(inflater, container, false)
        val view = binding.root

        issueImageView = binding.issueImageView
        captureImageButton = binding.captureImageButton
        issueTypeSpinner = binding.issueTypeSpinner
        submitReportButton = binding.submitReportButton

        setupIssueTypeSpinner()

        captureImageButton.setOnClickListener {
            dispatchTakePictureIntent()
        }
        submitReportButton.setOnClickListener {
            // Get the captured image as a bitmap
            val imageBitmap = (issueImageView.drawable as? BitmapDrawable)?.bitmap

            // Check if the imageBitmap is not null
            if (imageBitmap != null) {
                processImageAndSubmitReport(imageBitmap)
            } else {
                Snackbar.make(
                    requireView(),
                    "Error processing image: image not found",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        return view
    }

    private fun setupIssueTypeSpinner() {
        val issueTypes = arrayOf("Marine Plastics", "Bin Overflow", "Illegal Dumping", "Sewage Outflow", "Chemical Leak", "Oil Spill")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, issueTypes)
        issueTypeSpinner.adapter = adapter
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivityForResult(takePictureIntent, requestImageCapture)
        }
    }


    private fun processImageAndSubmitReport(imageBitmap: Bitmap) {
        // Use Firebase ML Kit to detect labels in the image
        detectLabels(imageBitmap)
    }


    private fun detectLabels(imageBitmap: Bitmap) {
        val image = InputImage.fromBitmap(imageBitmap, 0)
        val options = ImageLabelerOptions.Builder()
            .setConfidenceThreshold(0.7f)
            .build()

        val labeler: ImageLabeler = ImageLabeling.getClient(options)

        labeler.process(image)
            .addOnSuccessListener { labels ->
                handleLabels(labels)
            }
            .addOnFailureListener { e ->
                Snackbar.make(requireView(), "Error detecting labels: ${e.message}", Snackbar.LENGTH_LONG).show()
            }
    }

    private fun handleLabels(labels: List<ImageLabel>) {
        // Process the detected labels
        for (label in labels) {
            if (label.confidence >= 0.7f) {
                val labelName = label.text
                val confidence = label.confidence
                // Handle the label as needed
            }
        }

        // Implement logic to submit the report based on detected labels
        Snackbar.make(requireView(), "Report submitted successfully!", Snackbar.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == requestImageCapture && resultCode == Activity.RESULT_OK) {
            // Get the captured image as a bitmap
            val imageBitmap = data?.extras?.get("data") as? Bitmap
            imageBitmap?.let {
                issueImageView.setImageBitmap(imageBitmap)
                processImageAndSubmitReport(imageBitmap)
            }
        }
    }
}
