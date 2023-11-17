// NotificationService.kt

package notification

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.greenway.ohabluegrid.R

object NotificationService {

    private const val CHANNEL_ID = "your_channel_id" // Replace with your actual channel ID

    fun showNotification(context: Context, title: String, content: String) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification_icon) // Replace with your actual notification icon
            .setContentTitle(title)
            .setContentText(content)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(getNotificationId(), builder.build())
    }

    private fun getNotificationId(): Int {
        // Generate a unique notification ID based on your logic
        return System.currentTimeMillis().toInt()
    }
}
