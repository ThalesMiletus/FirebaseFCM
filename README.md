# FirebaseFCM
## _Used Tools and Components_

| Tools and Components |
| ------ |
| NotificationManager |
| FirebaseMessagingService|

TIP
---

If the app is running the background, if the message has a notification payload, the notification is
automatically shown in the notification tray.
If the message also has a data payload, the data payload will be handled by the app when the user
taps on the notification.

If the app is running in the foreground, if the message notification has a notification payload, the
notification will not appear automatically. The app needs to decide how to handle the notification
in the onMessageReceived() function.
If the message also has data payload, both payloads will be handled by the app.