package com.example.firebasefcm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    private val TOPIC = "myTopic"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        subscribeTopic()
    }

    private fun subscribeTopic() {
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)
                .addOnCompleteListener {
                    Toast.makeText(this, "Successfully Subscribed To Topic: ${it.isSuccessful}", Toast.LENGTH_LONG).show()
                }
    }
}