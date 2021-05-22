package es.jsalmoralp.apuntesandroidstudio

import android.app.AlertDialog
import android.content.Context

class AA1Librerias {
}

class Mensajeria {
    fun alert(vista: Context, titulo: String, mensaje: String) {
        val builder = AlertDialog.Builder(vista)
        builder.setTitle(titulo)
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}