package es.jsalmoralp.apuntesandroidstudio

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class AB1MyFirebaseMessagingService: FirebaseMessagingService() {
    // Mensajes en PrimerPLano
    override fun onMessageReceived(p0: RemoteMessage) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(baseContext, p0.notification?.title, Toast.LENGTH_LONG).show()
        }
    }
}