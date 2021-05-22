package es.jsalmoralp.apuntesandroidstudio

/**
 * Created by JSalmoralP by Joan Salmoral on 2021-05-16
 * www.jsalmoralp.es
 */
class MyProgramadorClass(
    var nombre: String,
    var edad: Int,
    var lenguajes: Array<Lenguaje>,
    var amigos: Array<MyProgramadorClass>? = null
) : MyPersonaClass(nombre, edad) {

    enum class Lenguaje {
        PHP,
        HTML5,
        CSS3,
        Java,
        Kotlin
    }
    fun yoSeProgramarEn() {
        for (lenguaje in lenguajes) {
            println("Se programar en $lenguaje")
        }
    }

    override fun trabajando() {
        println("Esta persona está Programando!")
    }
}