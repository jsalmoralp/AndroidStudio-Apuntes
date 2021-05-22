package es.jsalmoralp.apuntesandroidstudio

class MyDisenadorClass(
    val nombre: String,
    edad: Int,
    val editor: String
) : MyPersonaClass(nombre, edad), // Una Clase no puede Heredar de más de una Clase
    MyVeiculoInterface // Pero si puede tener más de una Interface
{
    /* HERENCIA
    La HERENCIA es un mecanismo de los lenguajes de POO basados en clases, y
    por medio de las cuales una clase se deriva de otra de manera
    que EXTIENDE su funcionalidad o la ESPECIALIZA.
     */
    //Cualquier clase tiene una superclase común "Any"

    override fun trabajando() {
        println("Esta persona está Diseñando!")
    }

    fun editorUsado() {
        println("Este Diseñador usa el Editor: $editor")
    }

    override fun irATrabajar() {
        println("Este Diseñador va a Trabajar en su puesto en Google!")
    }

    override fun conducir() {
        println("$nombre está conduciendo! ¡¡Profavor no molestar!!")
    }
}