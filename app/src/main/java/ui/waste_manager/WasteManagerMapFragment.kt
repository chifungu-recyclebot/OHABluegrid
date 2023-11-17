package ui.waste_manager

// WasteManagerMapFragment.kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ohabluegrid.databinding.FragmentWasteManagerMapBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class WasteManagerMapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentWasteManagerMapBinding
    private lateinit var mapView: MapView
    private var googleMap: GoogleMap? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWasteManagerMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
    }

    override fun onMapReady(gMap: GoogleMap?) {
        googleMap = gMap

        // Add a marker for demonstration purposes
        val markerLatLng = LatLng(37.7749, -122.4194)
        googleMap?.addMarker(MarkerOptions().position(markerLatLng).title("San Francisco"))

        // Move the camera to the marker
        googleMap?.moveCamera(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(markerLatLng, 10f))

        // Customize your map UI here if needed
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    companion object {
        fun newInstance(): WasteManagerMapFragment {
            return WasteManagerMapFragment()
        }
    }
}
