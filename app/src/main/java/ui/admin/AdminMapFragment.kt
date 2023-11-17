package ui.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.common.util.CollectionUtils.listOf
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.greenway.ohabluegrid.R





abstract class AdminMapFragment : Fragment(), OnMapReadyCallback {

    abstract val gMap: GoogleMap?
    private lateinit var mapView: MapView
    private var googleMap: GoogleMap? = null

    // Example: List of locations to display on the map
    private val locations: List<LatLng> = listOf(
        LatLng(37.7749, -122.4194),  // San Francisco
        LatLng(34.0522, -118.2437),  // Los Angeles
        LatLng(41.8781, -87.6298)    // Chicago
        // Add more locations as needed
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_admin_map, container, false)

        // Initialize the MapView
        mapView = view.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        return view
    }
    override fun onMapReady(p0: GoogleMap) {
        googleMap = gMap

        // Add markers based on the list of locations
        if (locations.isNotEmpty()) {
            for (location in locations) {
                googleMap?.addMarker(MarkerOptions().position(location).title("Marker"))
            }

            // Move the camera to the first location
            googleMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(locations[0], 10f))
        } else {
            // Handle the case when the locations list is empty
        }

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
}
