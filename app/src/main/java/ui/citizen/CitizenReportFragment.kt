package ui.citizen

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.greenway.ohabluegrid.R



class CitizenReportFragment : Fragment() {

    private val requestImageCapture = 1

    private lateinit var issueImageView: ImageView
    private lateinit var captureImageButton: Button
    private lateinit var issueTypeSpinner: Spinner
    private lateinit var submitReportButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_citizen_report, container, false)

        issueImageView = view.findViewById(R.id.issueImageView)
        captureImageButton = view.findViewById(R.id.captureImageButton)
        issueTypeSpinner = view.findViewById(R.id.issueTypeSpinner)
        submitReportButton = view.findViewById(R.id.submitReportButton)

        setupIssueTypeSpinner()

        captureImageButton.setOnClickListener {
            dispatchTakePictureIntent()
        }

        submitReportButton.setOnClickListener {
            submitReport()
        }

        return view
    }

    private fun setupIssueTypeSpinner() {
        val issueTypes = arrayOf(
            "Marine Plastics", "Bin Overflow", "Illegal Dumping",
            "Sewage Outflow", "Chemical Leak", "Oil Spill"
        )
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, issueTypes)
        issueTypeSpinner.adapter = adapter
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivityForResult(takePictureIntent, requestImageCapture)
        }
    }

    private fun submitReport() {
        // Get the selected issue type
        val selectedIssueType = issueTypeSpinner.selectedItem.toString()

        // Get the captured image as a Bitmap
        val imageBitmap = (issueImageView.drawable as? BitmapDrawable)?.bitmap

        // TODO: Implement the logic to send the report to the backend/API
        // Example: SendReportService.submitReport(selectedIssueType, imageBitmap)

        // For now, let's display a placeholder message
        // You should replace this with your actual logic for report submission
        showToast("Report submitted. Thank you!")
    }

    private fun showToast(message: String) {
        // Display a toast message (you can replace this with your preferred UI feedback)
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == requestImageCapture && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as? Bitmap
            imageBitmap?.let {
                issueImageView.setImageBitmap(imageBitmap)
            }
        }
    }
}
