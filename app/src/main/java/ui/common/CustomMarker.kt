// CustomMarker.kt

package ui.common

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.greenway.ohabluegrid.R

class CustomMarker(private val context: Context) {

    fun getMarkerView(bitmap: Bitmap?): View {
        val markerView = LayoutInflater.from(context).inflate(R.layout.custom_marker_layout, null)
        val markerImage = markerView.findViewById<ImageView>(R.id.markerImage)

        // Customize the marker view, e.g., set the bitmap to the ImageView
        markerImage.setImageBitmap(bitmap)

        return markerView
    }
}
