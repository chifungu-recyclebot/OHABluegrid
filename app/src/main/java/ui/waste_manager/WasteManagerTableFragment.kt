package ui.waste_manager

// WasteManagerTableFragment.kt


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.greenway.ohabluegrid.databinding.FragmentWasteManagerTableBinding
import dashboard.waste_manager.WasteManagerDashboardActivity

class WasteManagerTableFragment : Fragment() {

    private lateinit var binding: FragmentWasteManagerTableBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWasteManagerTableBinding.inflate(inflater, container, false)

        // Set click listener for the button to navigate to the map fragment
        binding.navigateToMapButton.setOnClickListener {
            (activity as? WasteManagerDashboardActivity)?.replaceFragment(WasteManagerMapFragment.newInstance())
        }

        return binding.root
    }

    companion object {
        fun newInstance(): WasteManagerTableFragment {
            return WasteManagerTableFragment()
        }
    }
}
