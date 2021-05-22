package es.jsalmoralp.apuntesandroidstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import es.jsalmoralp.apuntesandroidstudio.databinding.ActivityMma1b1PerfilUsuarioFirestoreBinding

class MMa1b1PerfilUsuarioFirestoreActivity : AppCompatActivity() {
    // [START] INSTANCIAS
    private lateinit var myLayout: ActivityMma1b1PerfilUsuarioFirestoreBinding

    private val db = FirebaseFirestore.getInstance()
    // [END] INSTANCIAS

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * INICIALIZACIÓN
         */
        // TODO: Traducir titulo Activity
        title = "Perfil Usuario"

        super.onCreate(savedInstanceState)
        myLayout = ActivityMma1b1PerfilUsuarioFirestoreBinding.inflate(layoutInflater)
        val view = myLayout.root
        setContentView(view)
        // [END] INICIALIZACIÓN

        /**
         * SetUp
         */
        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val proveedor: String? = bundle?.getString("proveedor")

        setup(email ?: "", proveedor ?: "")
        // [END] SetUp
    }

    /**
     * SETUP
     */
    private fun setup(email: String, proveedor: String) {
        // Click en el botón de Guardar
        myLayout.btnGuardar.setOnClickListener {
            try {
                db.collection("users").document(email).set(
                    hashMapOf(
                        "proveedor" to proveedor,
                        "direccion" to myLayout.etDireccion.text.toString(),
                        "telefono" to myLayout.etTelefono.text.toString()
                    )
                )
                Mensajeria().alert(
                    this,
                    "[INFO] Firestore DB",
                    "Se han guardado los datos en la Base de Datos de Firestore"
                )
            } catch (exception: FirebaseFirestoreException) {
                Mensajeria().alert(
                    this,
                    "[ERROR] Firestore DB",
                    "Error al guardar los datos en la Base de Datos de Firestore"
                )
            }
        }

        // Click en el botón de Recuperar
        myLayout.btnRecuperar.setOnClickListener {
            try {
                db.collection("users").document(email).get().addOnSuccessListener {
                    myLayout.etDireccion.setText(it.get("direccion") as String?)
                    myLayout.etTelefono.setText(it.get("telefono") as String?)
                }
                Mensajeria().alert(
                    this,
                    "[INFO] Firestore DB",
                    "Se han recuperado los datos en la Base de Datos de Firestore"
                )
            } catch (exception: FirebaseFirestoreException) {
                Mensajeria().alert(
                    this,
                    "[ERROR] Firestore DB",
                    "Error al recuperar los datos en la Base de Datos de Firestore"
                )
            }
        }

        // Click en el botón de Eliminar
        myLayout.btnEliminar.setOnClickListener {
            try {
                db.collection("users").document(email).delete()
                Mensajeria().alert(
                    this,
                    "[INFO] Firestore DB",
                    "Se han eliminado los datos en la Base de Datos de Firestore"
                )
            } catch (exception: FirebaseFirestoreException) {
                Mensajeria().alert(
                    this,
                    "[ERROR] Firestore DB",
                    "Error al eliminar los datos en la Base de Datos de Firestore"
                )
            }
        }
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