// CitizenMapFragment.kt

package ui.citizen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.MapView
import androidx.fragment.app.Fragment
import com.greenway.ohabluegrid.R

class CitizenMapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_citizen_map, container, false)
    }
}
