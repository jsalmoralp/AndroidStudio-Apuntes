package es.jsalmoralp.apuntesandroidstudio

open class MyPersonaClass(
    nombre: String,
    edad: Int
) : MyTrabajoClass(), MyJuegoInterface {
    /* HERENCIA
    La HERENCIA es un mecanismo de los lenguajes de POO basados en clases, y
    por medio de las cuales una clase se deriva de otra de manera
    que EXTIENDE su funcionalidad o la ESPECIALIZA.
     */
    //Cualquier clase tiene una superclase común "Any"

    open fun trabajando() {
        println("Esta persona está Trabajando!")
    }

    override fun irATrabajar() {
        println("Esta va a Trabajar!")
    }

    /**
     * Implementación de JuegoInterface
     */
    override val juego: String
        get() = "Among Us"
    //override val game: String = "Among Us" // Esto sería lo mismo

    override fun jugar() {
        println("Esta Persona está jugando a $juego")
    }
}