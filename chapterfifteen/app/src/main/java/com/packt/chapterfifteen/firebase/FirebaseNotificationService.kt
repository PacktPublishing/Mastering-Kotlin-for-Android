package com.packt.chapterfifteen.firebase

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.packt.chapterfifteen.R

class FirebaseNotificationService: FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("Firebase Token", token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        sendNotification(remoteMessage)
    }

    private fun sendNotification(remoteMessage: RemoteMessage) {
        val notification = NotificationCompat.Builder(applicationContext, "Pets Apps")
            .setContentTitle(remoteMessage.notification?.title)
            .setTicker(remoteMessage.notification?.ticker)
            .setContentText(remoteMessage.notification?.body)
            .setContentInfo(remoteMessage.notification?.body)
            .setStyle(NotificationCompat.BigTextStyle().bigText(remoteMessage.notification?.body))
            .setSmallIcon(R.drawable.ic_launcher_background)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
           createChannel(notification, "Pets Apps")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel(notificationBuilder: NotificationCompat.Builder, id: String) {
        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE)
        val channel = NotificationChannel(
            id,
            "Pets Apps",
            NotificationManager.IMPORTANCE_HIGH
        )
        channel.description = "Pets Apps"
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}