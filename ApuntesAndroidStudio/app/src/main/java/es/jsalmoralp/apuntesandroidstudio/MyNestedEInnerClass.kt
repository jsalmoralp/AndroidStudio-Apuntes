package es.jsalmoralp.apuntesandroidstudio

class MyNestedEInnerClass {

    val uno = 1
    private fun returnUno() : Int {
        return uno
    }

    // Clase Anidada (Nested Class)
    class MyNestedClass {
        /* CLASE ANIDADA o NESTED CLASS
        Está contenida dentro de otra clase, y favorece el ENCAPSULAMIENTO y
        NO PUEDE acceder a los miembros de la clase externa.
         */
        fun suma(primero: Int, segundo: Int) : Int {
            val resultado = primero + segundo
            //val resultado = primero + segundo "+ uno" // En este tipo de clase no se puede hacerlo
            return resultado
        }
    }

    // Clase Interna (Inner Class)
    inner class MyInnerClass {
        /* CLASE INTERNA o INNER CLASS
        Está contenida dentro de otra clase, y favorece el ENCAPSULAMIENTO y
        SÍ QUE PUEDE acceder a los miembros de la clase externa.
         */
        fun sumaMasDos(primero: Int) : Int {
            return primero + uno + returnUno()
        }
    }
}