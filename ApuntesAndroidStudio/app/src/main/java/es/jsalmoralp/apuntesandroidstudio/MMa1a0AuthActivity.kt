package es.jsalmoralp.apuntesandroidstudio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import es.jsalmoralp.apuntesandroidstudio.databinding.ActivityMma1a0AuthBinding

enum class ProviderType {
    BASIC,
    GOOGLE,
    FACEBOOK
}

class MMa1a0AuthActivity : AppCompatActivity() {
    // [START] INSTANCIAS
    private lateinit var myLayout: ActivityMma1a0AuthBinding
    private lateinit var myPrefsCredentials: SharedPreferences

    private val GOOGLE_SIGN_IN = 100
    private val callbackManagerFacebook = CallbackManager.Factory.create()
    // [END] INSTANCIAS

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * INICIALIZACIÓN
         */
        // TODO: Traducir titulo Activity
        title = "Login"

        super.onCreate(savedInstanceState)
        myLayout = ActivityMma1a0AuthBinding.inflate(layoutInflater)
        val view = myLayout.root
        setContentView(view)
        // [END] INICIALIZACIÓN

        /**
         * Archivos de Configuración
         */
        // Archivo de Config (en el propio dispositivo)->(hasta que la app se reinstala)
        myPrefsCredentials = getSharedPreferences(getString(R.string.prefs_file_credentials), Context.MODE_PRIVATE)

        // [START] Remote Config (Firebase) [Inicializar]
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 60
        }
        val firebaseConfig = Firebase.remoteConfig
        firebaseConfig.setConfigSettingsAsync(configSettings)
        firebaseConfig.setDefaultsAsync(mapOf("btn_falla_mostrar" to false, "btn_falla_text" to "Forzar Error"))
        // [END] Remote Config (Firebase) [Inicializar]
        // [END] Archivos de Configuración

        /**
         * SetUp
         */
        setup()
        sesion()
        notificacion()
    }

    /**
     * SETUP de Acciones de los Botones
     */
    private fun setup() {
        title = "Autenticación"

        // [START] Click del botón SignUp
        myLayout.btnSignUp.setOnClickListener {
            if (myLayout.etEmail.text.isNotEmpty() && myLayout.etPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    myLayout.etEmail.text.toString(),
                    myLayout.etPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHomeAuth(it.result?.user?.email ?: "", ProviderType.BASIC)
                    } else {
                        Mensajeria().alert(
                            this,
                            "Error",
                            "Se ha producido un error autenticando al usuario"
                        )
                    }
                }
            }
        }
        // [END] Click del botón SignUp

        // [START] Click en el botón Login
        myLayout.btnLogin.setOnClickListener {
            if (myLayout.etEmail.text.isNotEmpty() && myLayout.etPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    myLayout.etEmail.text.toString(),
                    myLayout.etPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHomeAuth(it.result?.user?.email ?: "", ProviderType.BASIC)
                    } else {
                        Mensajeria().alert(
                            this,
                            "Error",
                            "Se ha producido un error autenticando al usuario"
                        )
                    }
                }
            }
        }
        // [END] Click en el botón Login

        // [START] Click en el botón de Acceder con Google
        myLayout.btnGoogle.setOnClickListener {
            val googleConf =
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build()
            val googleClient = GoogleSignIn.getClient(this, googleConf)
            googleClient.signOut()
            startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)
        }
        // [END] Click en el botón de Acceder con Google

        // [START] Click en el botón de Acceder con Facebook
        myLayout.btnFacebook.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this, listOf("email"))

            LoginManager.getInstance().registerCallback(callbackManagerFacebook,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(result: LoginResult?) {
                        result?.let {
                            val token = it.accessToken

                            val credential = FacebookAuthProvider.getCredential(token.token)
                            FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                                if (it.isSuccessful) {
                                    showHomeAuth(it.result?.user?.email ?: "", ProviderType.FACEBOOK)
                                } else {
                                    Mensajeria().alert(
                                        this@MMa1a0AuthActivity,
                                        "Error en Facebook",
                                        "Se ha producido un error autenticando al usuario en Facebook"
                                    )
                                }
                            }
                        }
                    }

                    override fun onCancel() {
                        TODO("Not yet implemented")
                    }

                    override fun onError(error: FacebookException?) {
                        Mensajeria().alert(
                            this@MMa1a0AuthActivity,
                            "Error en Facebook",
                            "Se ha producido un error autenticando al usuario en Facebook"
                        )
                    }
                })
        }
        // [END] Click en el botón de Acceder con Facebook
    }
    // [END] SETUP de Acciones de los Botones

    /**
     * INTERACCION con Firebase de las Acciones de "Google" y "Facebook"
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // [START] Facebook
        callbackManagerFacebook.onActivityResult(requestCode, resultCode, data)
        // [END] Facebook

        super.onActivityResult(requestCode, resultCode, data)

        // [START] Google
        if (requestCode == GOOGLE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)

                if (account != null) {
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHomeAuth(account.email ?: "", ProviderType.GOOGLE)
                        } else {
                            Mensajeria().alert(
                                this,
                                "Error en Google",
                                "Se ha producido un error autenticando al usuario en Google"
                            )
                        }
                    }
                }
            } catch (e: ApiException) {
                Mensajeria().alert(
                    this,
                    "Error en Google",
                    "Se ha producido un error autenticando al usuario en Google"
                )
            }
        }
        // [END] Google
    }
    // [END] INTERACCION con Firebase de las Acciones de "Google" y "Facebook"

    /**
     * SESIÓN
     */
    private fun sesion() {
        val email = myPrefsCredentials.getString("email", null)
        val proveedor = myPrefsCredentials.getString("proveedor", null)

        if (email != null && proveedor != null) {
            myLayout.llAuth.visibility = View.INVISIBLE
            showHomeAuth(email, ProviderType.valueOf(proveedor))
        }
    }
    // [END] SESIÓN

    override fun onStart() {
        super.onStart()

        myLayout.llAuth.visibility = View.VISIBLE
    }

    /**
     * NOTIFICACIONES
     */
    private fun notificacion() {
        // Obtener token único de cada dispositivo
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            it.result?.let {
                println("Este es el token del dispositivo: ${it}")
            }
        }

        // Temas (Topics)
        FirebaseMessaging.getInstance().subscribeToTopic("basicos")

        // Recuprar info de una notificación (objetos = clave -> valor)
        val url = intent.getStringExtra("url")
        url?.let {
            println("Ha llegado información en una push ${it}")
        }
    }
    // [END] NOTIFICACIONES

    /**
     * Función de Redirección
     */
    private fun showHomeAuth(email: String, proveedor: ProviderType) {
        val homeAuthIntent = Intent(
            this,
            MMa1a1HomeAuthActivity::class.java
        ).apply {
            putExtra("email", email)
            putExtra("proveedor", proveedor.name)
        }
        startActivity(homeAuthIntent)
    }
    // [END] Función de Redirección

}