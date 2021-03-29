package com.example.firebasefcm.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.firebasefcm.MainActivity
import com.example.firebasefcm.R

private const val NOTIFICATION_ID = 0

fun NotificationManager.sendNotification(messageBody: String, context: Context) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

        val notificationChannel = NotificationChannel(
                context.getString(R.string.my_notification_channel_id),
                context.getString(R.string.my_notification_channel_name),
                NotificationManager.IMPORTANCE_HIGH)
                .apply {
                    setShowBadge(false)
                    enableLights(true)
                    lightColor = Color.RED
                    enableVibration(true)
                    description = context.getString(R.string.my_notification_channel_description)
                }
        createNotificationChannel(notificationChannel)
    }

    val contentIntent = Intent(context, MainActivity::class.java)

    val contentPendingIntent = PendingIntent.getActivity(
            context,
            NOTIFICATION_ID,
            contentIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
    )

    val alarmImage = BitmapFactory.decodeResource(context.resources, R.drawable.big_image)

    val bigPicStyle = NotificationCompat.BigPictureStyle()
            .bigPicture(alarmImage)
            .bigLargeIcon(null)

    val builder = NotificationCompat.Builder(context, context.getString(R.string.my_notification_channel_id))
            .setSmallIcon(R.drawable.ic_clock)
            .setContentTitle(context.getString(R.string.notification_title))
            .setContentText(messageBody)
            .setContentIntent(contentPendingIntent)
            .setAutoCancel(true)
            .setStyle(bigPicStyle)
            .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.alarm_icn))
            .setPriority(NotificationCompat.PRIORITY_HIGH)

    notify(NOTIFICATION_ID, builder.build())
}