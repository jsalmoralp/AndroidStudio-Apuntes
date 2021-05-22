package es.jsalmoralp.apuntesandroidstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.crashlytics.FirebaseCrashlytics
import es.jsalmoralp.apuntesandroidstudio.databinding.ActivityMma0SplashScreenBinding

class MMa0SplashScreenActivity : AppCompatActivity() {
    // [START] INSTANCIAS
    private lateinit var myLayout: ActivityMma0SplashScreenBinding
    // [END] INSTANCIAS

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * Crashlytics
         */
        val crashlytics = FirebaseCrashlytics.getInstance()
        //crashlytics.log("my message")
        // To log a message to a crash report, use the following syntax:
        //crashlytics.log("E/TAG: my message")
        crashlytics.log("M/INFO: App Iniciada")
        // [END] Crashlytics

        /**
         * SPLASH SCREEN
         */
        // Realizamos un adormecimiento de la APP (para que se vea más el "SplashScreen").
        //Thread.sleep(2_000)
        // Volvemos a poner el "Theme" que le pertocaría tener.
        setTheme(R.style.Theme_Main)
        // [END] SPLASH SCREEN

        /**
         * Cambio a la Activity Principal
         */
        val siguienteIntent = Intent(
            this,
            MMa1a0AuthActivity::class.java
        )
        startActivity(siguienteIntent)
        // [END] Cambio a la Activity Principal

        /**
         * INICIALIZACION
         */
        super.onCreate(savedInstanceState)
        myLayout = ActivityMma0SplashScreenBinding.inflate(layoutInflater)
        val view = myLayout.root
        setContentView(view)
        // [END] INICIALIZACIÓN
    }
}