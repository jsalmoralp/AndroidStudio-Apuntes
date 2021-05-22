package es.jsalmoralp.apuntesandroidstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import es.jsalmoralp.apuntesandroidstudio.databinding.ActivityMmaFirebaseBinding

class MMaFirebaseActivity : AppCompatActivity() {
    // [START] INSTANCIAS
    private lateinit var myLayout: ActivityMmaFirebaseBinding
    // [END] INSTANCIAS

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * INICIALIZACIÓN
         */
        // TODO: Traducir titulo Activity
        title = "Firebase Analytics"

        super.onCreate(savedInstanceState)
        myLayout = ActivityMmaFirebaseBinding.inflate(layoutInflater)
        val view = myLayout.root
        setContentView(view)
        // [END] INICIALIZACIÓN

        /**
         * EVENTOS DE GOOGLE ANALYTICS
         * Estos eventos son lanzados a GoggleAnalytics,
         * y que podremos ver en nuestra consola de Firebase.
         */
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integración de Firebase completa")
        analytics.logEvent("InitScreen", bundle)
        // [END] EVENTOS DE GOOGLE ANALYTICS
    }

    /**
     * Boton "Back"
     */
    // Implementar la función de volver atrás, para que lo haga en nuestras búsquedas
    override fun onBackPressed() {
        val misActivitiesIntent = Intent(
            this,
            MMa2a00MisActivitiesActivity::class.java
        )
        startActivity(misActivitiesIntent)
    }
    // [END] Boton "Back"
}