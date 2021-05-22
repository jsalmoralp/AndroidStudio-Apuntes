package es.jsalmoralp.apuntesandroidstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.graphics.Bitmap
import android.webkit.*
import android.widget.SearchView
import es.jsalmoralp.apuntesandroidstudio.databinding.ActivityMmaWebViewBinding

class MMaWebViewActivity : AppCompatActivity() {
    // [START] INSTANCIAS
    private lateinit var myLayout: ActivityMmaWebViewBinding

    // Instanciamos la URL base con la que va a trabajar nuestra APP
    private val myBaseURL: String = "https://google.com"
    // Instanciamos la URL con la que vamos a realizar una búsqueda
    private val myPathBusqueda: String = "/search?q="
    // [END] INSTANCIAS

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * INICIALIZACION
         */
        // TODO: Traducir titulo Activity
        title = "Visor Web"

        super.onCreate(savedInstanceState)
        myLayout = ActivityMmaWebViewBinding.inflate(layoutInflater)
        val view = myLayout.root
        setContentView(view)
        // [END] INICIALIZACIÓN

        /**
         * WebView
         */
        // Trabajando con la versión "Chrome"
        myLayout.wvVisor.webChromeClient = object : WebChromeClient() {

        }

        // Trabajando con la versión "Firefox" y otras
        myLayout.wvVisor.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                myLayout.svBuscador.setQuery(url, false)

                myLayout.srlRefrescador.isRefreshing = true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                myLayout.srlRefrescador.isRefreshing = false
            }
        }

        // Activamos la funcionalidad "JavaScript"
        myLayout.wvVisor.settings.javaScriptEnabled = true

        // Designamos la url que se va a cargar en primera instancia
        myLayout.wvVisor.loadUrl(myBaseURL)
        // [END] WebView

        /**
         * Refrescador ("Refresh" o "Reload")
         */
        // Instanciamos el "Listener" para cuando realicemos la acción de refrescar
        myLayout.srlRefrescador.setOnRefreshListener {
            myLayout.wvVisor.reload()
        }
        // [END] Refrescador

        /**
         * Buscador
         */
        myLayout.svBuscador.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                p0 ?.let {
                    if (URLUtil.isValidUrl(it)) {
                        myLayout.wvVisor.loadUrl(it)
                    } else {
                        myLayout.wvVisor.loadUrl("${myBaseURL}${myPathBusqueda}${it}")
                    }
                }

                return false
            }
        })
        // [END] Buscador
    }

    /**
     * Boton "Back"
     */
    // Implementar la función de volver atrás, para que lo haga en nuestras búsquedas
    override fun onBackPressed() {
        if (myLayout.wvVisor.canGoBack()) {
            myLayout.wvVisor.goBack()
        } else {
            val misActivitiesIntent = Intent(
                this,
                MMa2a00MisActivitiesActivity::class.java
            )
            startActivity(misActivitiesIntent)
        }
    }
    // [END] Boton "Back"
}
