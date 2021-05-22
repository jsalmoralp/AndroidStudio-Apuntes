package es.jsalmoralp.apuntesandroidstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.jsalmoralp.apuntesandroidstudio.databinding.ActivityMma2a00MisActivitesBinding

class MMa2a00MisActivitiesActivity : AppCompatActivity() {
    // [START] INSTANCIAS
    private lateinit var myLayout: ActivityMma2a00MisActivitesBinding
    // [END] INSTANCIAS

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * INICIALIZACIÓN
         */
        // TODO: Traducir titulo Activity
        title = "Menu Activities"

        super.onCreate(savedInstanceState)
        myLayout = ActivityMma2a00MisActivitesBinding.inflate(layoutInflater)
        val view = myLayout.root
        setContentView(view)
        // [END] INICIALIZACIÓN

        /**
         * SetUp
         */
        setup()
        // [END] SetUp
    }

    /**
     * SETUP
     */
    private fun setup() {
        // [START] Botón Calculadora (cambio de activity)
        myLayout.btnCalculadora.setOnClickListener {
            val calculadoraIntent = Intent(
                this,
                MMaCalculadoraActivity::class.java
            )
            startActivity(calculadoraIntent)
        }
        // [END] Botón Calculadora (cambio de activity)

        // [START] Botón WeView (cambio de activity)
        myLayout.btnWebView.setOnClickListener {
            val weViewIntent = Intent(
                this,
                MMaWebViewActivity::class.java
            )
            startActivity(weViewIntent)
        }
        // [END] Botón WeView (cambio de activity)

        // [START] Botón Datos Persistentes (cambio de activity)
        myLayout.btnDatosPersistentes.setOnClickListener {
            val datosPersistentesIntent = Intent(
                this,
                MMaDatosPersistentesActivity::class.java
            )
            startActivity(datosPersistentesIntent)
        }
        // [END] Botón Datos Persistentes (cambio de activity)

        // [START] Botón Fuentes de Texto (cambio de activity)
        myLayout.btnFuentesTexto.setOnClickListener {
            val fuentesTextoIntent = Intent(
                this,
                MMaFuentesActivity::class.java
            )
            startActivity(fuentesTextoIntent)
        }
        // [END] Botón Fuentes de Texto (cambio de activity)

        // [START] Botón Firebase Analytics (cambio de activity)
        myLayout.btnFirebaseAnalytics.setOnClickListener {
            val firebaseAnalyticsIntent = Intent(
                this,
                MMaFirebaseActivity::class.java
            )
            startActivity(firebaseAnalyticsIntent)
        }
        // [END] Botón Firebase Analytics

        // [START] Botón Animaciones Lottie (cambio de activity)
        myLayout.btnAnimacionesLottie.setOnClickListener {
            val animacionesLottieIntent = Intent(
                this,
                MMaImagenesAnimadasActivity::class.java
            )
            startActivity(animacionesLottieIntent)
        }
        // [END] Botón Animaciones Lottie (cambio de activity)
    }
    // [END] SETUP

    /**
     * Boton "Back"
     */
    // Implementar la función de volver atrás, para que lo haga en nuestras búsquedas
    override fun onBackPressed() {
        val homeAuthIntent = Intent(
            this,
            MMa1a1HomeAuthActivity::class.java
        )
        startActivity(homeAuthIntent)
    }
    // [END] Boton "Back"
}