package es.jsalmoralp.apuntesandroidstudio

// INTRODUCCIÓN
class MyVisibilidadClass {
    /* MODIFICADORES DE VISIBILIDAD
    Las CLASES, OBJETOS, INTERFACES, CONSTRUCTORES, FUNCIONES, y PROPIEDADES y accesos GET/SET,
    pueden tener modificadores de visibilidad.
    Estos pueden ser:
        - PublicS
        - Private
        - Protected
        - Internal
    Por defecto, si no se especifica nada, tendrán el valor por defecto de "public".
     */
}

// MODIFICADOR PUBLIC
public class VisibilidadPublicClass {
    /* MODIFICADOR DE VISIBILIDAD "Public"
    Es el Modificador de Visibilidad por defecto.
    El Modificador de Visibilidad "Public", define las Declaraciones de forma que son
    visibles y accesibles desde cualquier parte de nuestro código.
     */
    public var nombrePublic: String? = null
    public fun diMiNombrePublic() {
        nombrePublic?.let {
            println("Mi nombre es $it")
        } ?: run {
            println("Aún no tengo nombre...")
        }
    }
}

//MODIFICADOR PRIVATE
private class VisibilidadPrivateClass {
    /* MODIFICADOR DE VISIBILIDAD "Private"
    El Modificador de Visibilidad "Private", define las Declaraciones de forma que son
    invisibles e inaccesibles desde cualquier parte de nuestro código.
    Exceptuando alguna posibilidad como la que vemos más adelante (solo dentro del mismo fichero).
     */
    var nombrePrivate: String? = null
    private fun diMiNombrePivate() {
        nombrePrivate?.let {
            println("Mi nombre es $it")
        } ?: run {
            println("Aún no tengo nombre...")
        }
    }
}

// MODIFICADOR PORTECTED
open class VisibilidadProtectedClass {
    protected fun diMiNombreProtected() {
        /* POSIBILIDADES del Modificador de Visibilidad "Private"
        De los elementos declarados como "Private",
        NO SE PUEDE acceder a ellos desde cualquier sitio,
        SOLO SE PODRÁ acceder a ellos desde una funcion de una clase, echa dentro del mismo fichero.
         */
        val visibilidadPrivada = VisibilidadPrivateClass()
        // Aunque la clase es privada, y al ser este un elemento no privado, podemos acceder a él
        visibilidadPrivada.nombrePrivate = "Salmoral"
        // NO tenemos Acceso a este ya que es privado, y solo se pude ver desde la propia clase
        //visibilidadPrivada.diMiApellidoPrivate()
    }
}
class VisibilidadProtectedClass2: VisibilidadProtectedClass() {
    /* MODIFICADOR DE VISIBILIDAD "Protected"
    Podremos acceder a ellos cuando estemos en una clase que herede de esta,
    ya que en las clases que heredan de un "Protected", este srá accesible desde esta.
     */
    fun diMiNombreProtected2() {
        diMiNombreProtected()
    }
}

// MODIFICADOR INTERNAL
class VisibilidadInternalClass {
    /* MODIFICADOR DE VISIBILIDAD "Internal"
    Podemos acceder a los elementos declarados como "Internal",
    desde cualquier parte de nuestro módulo (nuestra App en este caso).
     */
    internal val nombreInternal: String? = null
    internal fun diMiNombreInternal() {
        nombreInternal?.let {
            println("Mi nombre es $it")
        } ?: run {
            println("Aún no tengo nombre...")
        }
    }
}
