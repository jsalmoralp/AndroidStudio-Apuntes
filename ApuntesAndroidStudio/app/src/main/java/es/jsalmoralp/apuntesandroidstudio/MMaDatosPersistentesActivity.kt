package es.jsalmoralp.apuntesandroidstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.content.Intent
import android.preference.PreferenceManager
import es.jsalmoralp.apuntesandroidstudio.databinding.ActivityMmaDatosPersistentesBinding

class MMaDatosPersistentesActivity : AppCompatActivity() {
    // [START] INSTANCIAS
    private lateinit var myLayout: ActivityMmaDatosPersistentesBinding

    private val key: String = "MY_KEY"
    // [END] INSTANCIAS

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * INICIALIZACIÓN
         */
        // TODO: Traducir titulo Activity
        title = "Datos Persistentes"

        super.onCreate(savedInstanceState)
        myLayout = ActivityMmaDatosPersistentesBinding.inflate(layoutInflater)
        val view = myLayout.root
        setContentView(view)
        // [END] INICIALIZACIÓN

        // Obteneción del "PreferenceManager"
        // TODO: Arreglar con libreria actualizada (el "PreferenceManager" está deprecado)
        // TODO: Mirar para arreglar esto en "Archivos de Configuración" de (MMa1a0AuthActivity)
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        /**
         * LISTENERS Y ACCIONES DE LOS BOTONES
         */
        // Recupera las preferencias
        myLayout.btnObtener.setOnClickListener {
            val myPref = prefs.getString(key, "No hay un valor para esta clave")
            showAlert(myPref)
        }

        // Guarda las prferencias
        myLayout.btnGuardar.setOnClickListener {
            val editor = prefs.edit()
            editor.putString(key, "Valor de pruebas")
            editor.apply()
            showAlert("He guardado un valor")
        }

        // Elimina las preferencias
        myLayout.btnEliminar.setOnClickListener {
            val editor = prefs.edit()
            editor.remove(key)
            editor.apply()
            showAlert("He borrado un valor")
        }
    }

    /**
     * FUNCIÓN ADICIONAL (PARA MOSTRAR ALERTAS)
     */
    private fun showAlert(mensaje: String?) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Datos Persistentes")
        mensaje ?.let {
            builder.setMessage(it)
        } ?: run {
            builder.setMessage("El mensaje es Nulo")
        }
        val dialog = builder.create()
        dialog.show()
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