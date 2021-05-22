package es.jsalmoralp.apuntesandroidstudio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import es.jsalmoralp.apuntesandroidstudio.databinding.ActivityMma1a1HomeAuthBinding

class MMa1a1HomeAuthActivity : AppCompatActivity() {
    // [START] INSTANCIAS
    private lateinit var myLayout: ActivityMma1a1HomeAuthBinding
    private lateinit var myPrefsCredentials: SharedPreferences
    // [END] INSTANCIAS

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * INICIALIZACIÓN
         */
        // TODO: Traducir titulo Activity
        title = "Home Auth"

        super.onCreate(savedInstanceState)
        myLayout = ActivityMma1a1HomeAuthBinding.inflate(layoutInflater)
        val view = myLayout.root
        setContentView(view)
        // [END] INICIALIZACIÓN

        /**
         * Archivos de Configuración
         */
        // Archivo de Config (en el propio dispositivo)->(hasta que la app se reinstala)
        myPrefsCredentials = getSharedPreferences(getString(R.string.prefs_file_credentials), Context.MODE_PRIVATE)

        // [START] Remote Config (Firebase) [Obtener Info] y actualizar nuestro "Layout"
        myLayout.btnFalla.visibility = View.INVISIBLE
        Firebase.remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val mostrarBtnFalla = Firebase.remoteConfig.getBoolean("btn_falla_mostrar")
                val textBtnFalla = Firebase.remoteConfig.getString("btn_falla_text")

                if (mostrarBtnFalla) {
                    myLayout.btnFalla.visibility = View.VISIBLE
                } else {
                    myLayout.btnFalla.visibility = View.INVISIBLE
                }
                myLayout.btnFalla.text = textBtnFalla
            }
        }
        // [END] Remote Config (Firebase) [Obtener Info] y actualizar nuestro "Layout"
        // [END] Archivos de Configuración


        /**
         * SetUp
         */
        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val proveedor: String? = bundle?.getString("proveedor")

        setup(email ?: "", proveedor ?: "")
        // [END] SetUp

        /**
         * Guardado de Datos (para proximas sesiones)
         */
        // Guardado de dtos Persistentes
        myPrefsCredentials.edit().putString("email", email)
        myPrefsCredentials.edit().putString("proveedor", proveedor)
        myPrefsCredentials.edit().apply()
        // [END] Guardado de Datos (para proximas sesiones)

    }

    /**
     * SETUP
     */
    private fun setup(email: String, proveedor: String) {
        // Cambiamos el titulo de la Activity
        title = "Inicio"

        // Rellenamos los TextView
        myLayout.tvEmail.text = email
        myLayout.tvProveedor.text = proveedor

        // [START] Botón de Desconectar
        myLayout.btnLogout.setOnClickListener {
            // Borrado de datos Persistentes
            myPrefsCredentials.edit().clear()
            myPrefsCredentials.edit().apply()

            // Si se a conectado através de Facebook, desconectamos la cuenta de Facebook
            if (proveedor == ProviderType.FACEBOOK.name) {
                LoginManager.getInstance().logOut()
            }

            // Desconectamos la cuenta en firebase
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
        // [END] Botón de Desconectar

        // [START] Botón Falla
        myLayout.btnFalla.setOnClickListener {
            // Set de Información Extra para Crashlytics
            FirebaseCrashlytics.getInstance().setUserId(email)
            FirebaseCrashlytics.getInstance().setCustomKey("proveedor", proveedor)
            // Forzado de error
            throw RuntimeException("Forzado de error")
        }
        // [END] Botón Falla

        // [START] Botón Perfil Usuario (Firestore)
        myLayout.btnPerfilUsuarioFirestore.setOnClickListener {
            val perfilUsuarioFirestoreIntent = Intent(
                this,
                MMa1b1PerfilUsuarioFirestoreActivity::class.java
            ).apply {
                putExtra("email", email)
                putExtra("proveedor", proveedor)
            }
            startActivity(perfilUsuarioFirestoreIntent)
        }
        // [END] Botón Perfil Usuario (Firestore)

        // [START] Botón Otras Activities (Semi Menu)
        myLayout.btnOtrasActivities.setOnClickListener {
            val otrasActivitiesIntent = Intent(
                this,
                MMa2a00MisActivitiesActivity::class.java
            )
            startActivity(otrasActivitiesIntent)
        }
        // [END] Botón Otras Activities (Semi Menu)
    }
    // [END] SETUP
}