package es.jsalmoralp.apuntesandroidstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.jsalmoralp.apuntesandroidstudio.databinding.ActivityMmaCalculadoraBinding

class MMaCalculadoraActivity : AppCompatActivity() {
    // [START] INSTANCIAS
    private lateinit var myLayout: ActivityMmaCalculadoraBinding

    private var operacion: Int = 0
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    // [END] INSTANCIAS

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * INICIALIZACIÓN
         */
        // TODO: Traducir titulo Activity
        title = "Calculadora"

        super.onCreate(savedInstanceState)
        myLayout = ActivityMmaCalculadoraBinding.inflate(layoutInflater)
        val view = myLayout.root
        setContentView(view)
        // [END] INICIALIZACIÓN

        /**
         * LISTENERS DE LOS BOTONES
         */
        myLayout.btn0.setOnClickListener { numeroPresionado(digito = "0") }
        myLayout.btn1.setOnClickListener { numeroPresionado(digito = "1") }
        myLayout.btn2.setOnClickListener { numeroPresionado(digito = "2") }
        myLayout.btn3.setOnClickListener { numeroPresionado(digito = "3") }
        myLayout.btn4.setOnClickListener { numeroPresionado(digito = "4") }
        myLayout.btn5.setOnClickListener { numeroPresionado(digito = "5") }
        myLayout.btn6.setOnClickListener { numeroPresionado(digito = "6") }
        myLayout.btn7.setOnClickListener { numeroPresionado(digito = "7") }
        myLayout.btn8.setOnClickListener { numeroPresionado(digito = "8") }
        myLayout.btn9.setOnClickListener { numeroPresionado(digito = "9") }
        myLayout.btnComa.setOnClickListener { numeroPresionado(digito = ".") }
        myLayout.btnIgual.setOnClickListener {
            val resultado = when (operacion) {
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2
                else -> 0
            }
            num1 = resultado.toString().toDouble()
            myLayout.tvPantalla.text = mostrarResultadoConSinComa(num1)
        }
        myLayout.btnC.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            myLayout.tvPantalla.text = "0"
            operacion = 0
            myLayout.tvPantalla.text
        }
        myLayout.btnNegativo.setOnClickListener {
            if (operacion == 0) {
                num1 *= (-1)
                myLayout.tvPantalla.text = mostrarResultadoConSinComa(num1)
            } else {
                num2 *= (-1)
                myLayout.tvPantalla.text = mostrarResultadoConSinComa(num2)
            }

        }
        myLayout.btnPorcentaje.setOnClickListener {
            num2 = (num1 * myLayout.tvPantalla.text.toString().toDouble()) / 100
            myLayout.tvPantalla.text = mostrarResultadoConSinComa(num2)
        }

        myLayout.btnSumar.setOnClickListener { operacionPresionada(operacion = SUMA) }
        myLayout.btnRestar.setOnClickListener { operacionPresionada(operacion = RESTA) }
        myLayout.btnMultiplicar.setOnClickListener {
            operacionPresionada(operacion = MULTIPLICACION)
        }
        myLayout.btnDividir.setOnClickListener { operacionPresionada(operacion = DIVISION) }
        // [END] LISTENERS DE LOS BOTONES
    }

    /**
     * FUNCIONES PARA LAS OPERACIONES
     */
    // Operaciones
    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
    }

    // AlPresionar un boton Numérico
    private fun numeroPresionado(digito: String) {
        if (digito != ".") {
            if (myLayout.tvPantalla.text == "0") {
                if (digito != "0") {
                    myLayout.tvPantalla.text = digito
                }
            } else {
                myLayout.tvPantalla.text = "${myLayout.tvPantalla.text}$digito"
            }

            if (operacion == 0) {
                num1 = myLayout.tvPantalla.text.toString().toDouble()
            } else {
                num2 = myLayout.tvPantalla.text.toString().toDouble()
            }
        } else {
            myLayout.tvPantalla.text = "${myLayout.tvPantalla.text}$digito"
        }
    }

    // Al Presionar un boton de Operación
    private fun operacionPresionada(operacion: Int) {
        this.operacion = operacion
        myLayout.tvPantalla.text = "0"
    }

    // Mostrar con o sin ".0" el Resultado
    private fun mostrarResultadoConSinComa(resultadoFinal: Double): String {
        if (resultadoFinal == resultadoFinal.toInt().toDouble()) {
            return resultadoFinal.toInt().toString()
        }
        return resultadoFinal.toString()
    }
    // [END] FUNCIONES PARA LAS OPERACIONES

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