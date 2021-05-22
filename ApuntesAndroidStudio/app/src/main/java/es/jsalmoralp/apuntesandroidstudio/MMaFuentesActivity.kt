package es.jsalmoralp.apuntesandroidstudio

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.jsalmoralp.apuntesandroidstudio.databinding.ActivityMmaFuentesBinding

class MMaFuentesActivity : AppCompatActivity() {
    // [START] INSTANCIAS
    private lateinit var myLayout: ActivityMmaFuentesBinding
    // [END] INSTANCIAS

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * INICIALIZACIÓN
         */
        // TODO: Traducir titulo Activity
        title = "Fuentes Texto"

        super.onCreate(savedInstanceState)
        myLayout = ActivityMmaFuentesBinding.inflate(layoutInflater)
        val view = myLayout.root
        setContentView(view)
        // [END] INICIALIZACIÓN

        /**
         * ASIGNACIÓN DE FUENTES, a partir de archivos ".ttf" incluidos en assets "assets/fonts"
         */
        val typeFaceSewer: Typeface = Typeface.createFromAsset(assets, "fonts/sewer.ttf")
        val typeFaceGrasping: Typeface = Typeface.createFromAsset(assets, "fonts/grasping.ttf")
        myLayout.tvSewer.typeface = typeFaceSewer
        myLayout.tvGrasping.typeface = typeFaceGrasping
        // [END] ASIGNACIÓN DE FUENTES
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