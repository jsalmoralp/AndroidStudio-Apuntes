package es.jsalmoralp.apuntesandroidstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.jsalmoralp.apuntesandroidstudio.databinding.ActivityMmaApuntesKotlinBinding


class MMaApuntesKotlinActivity : AppCompatActivity() {
    // [START] INSTANCIAS
    private lateinit var myLayout: ActivityMmaApuntesKotlinBinding
    // [END] INSTANCIAS

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * INICIALIZACIÓN
         */
        // TODO: Traducir titulo Activity
        title = "Apuntes Kotlin"

        super.onCreate(savedInstanceState)
        myLayout = ActivityMmaApuntesKotlinBinding.inflate(layoutInflater)
        val view = myLayout.root
        setContentView(view)
        // [END] INICIALIZACIÓN

        // ¡Comentar las partes que NO se quieran testear!
        /**
         * APUNTES DE KOTLIN
         */
        // [START] KOTLIN NIVEL BÁSICO
        variablesYConstantes()
        tiposDeDatos()
        sentenciaIf()
        sentenciaWhen()
        arrays()
        mapas()
        loops()
        nullSafety()
        funciones()
        clases()
        // [END] KOTLIN NIVEL BÁSICO
        // [START] KOTLIN NIVEL INTERMEDIO
        enumClases()
        nestedEInnerClases()
        herenciaDeClases()
        interfaces()
        modificadoresDeVisiblilidad()
        // [END] KOTLIN NIVEL INTERMEDIO
        // [END] APUNTES DE KOTLIN
    }

    /**
     * KOTLIN NIVEL BÁSICO
     */
    /*
    Aquí vamos a hablar de Variables y Constantes
     */
    private fun variablesYConstantes() {

        // VARIABLES

        var myFirstVariable = "Esta es mi primera variable!"
        var myFirstNumber = 1
        println(myFirstVariable)
        println(myFirstNumber)

        myFirstVariable = "Cambio el valor de mi primera variable"
        println(myFirstVariable)

        // No podemos asignar un tipo Int a una variable de tipo String
        //myFirstVariable = 1

        var mySecondVariable = "Esta es mi segunda variable!"
        println(mySecondVariable)

        var myThirdVariable = myFirstVariable + " y " + mySecondVariable
        println(myThirdVariable)

        // CONSTANTES

        val myFirstConstant = "Esta es mi primera constante!"
        println(myFirstConstant)

        // Una constante no puede modificar su valor
        //myFirstConstant = "Cambio el valor de mi primera constante ..."

        val mySecondConstant = myFirstVariable
        println(mySecondConstant)
    }

    /*
    Aquí vamos a hablar de los Tipos de Datos
     */
    private fun tiposDeDatos() {

        // STRINGS

        val myString = "Esta es mi primera String!"
        val myString2: String = "Esta es mi primera String 2!"
        val myString3: String = myString + " y " + myString2
        println(myString3)

        // ENTEROS (byte, Short, Int, Long)

        val myInt = 1
        val myInt2: Int = 2
        val myInt3: Int = myInt + myInt2
        println(myInt3)

        // DECIMALES (Float, Double)

        val myFloat = 1.5f
        val myFloat2: Float = 1.6f
        println(myFloat+myFloat2)

        val myDouble = 1.5
        val myDouble2: Double = 2.6
        val myDouble3 = 1 // En realidad esto es un "Int"
        val myDouble4 = myDouble + myDouble2 + myDouble3
        println(myDouble4)

        // BOOLEAN (Boolean)

        val myBool = true
        val myBool2: Boolean = false

        // No se pueden sumar este tipo de datos ni concatenarlos
        //val myBool3 = myBool + myBool2

        println(myBool == myBool2) // Es igual
        println(myBool != myBool2) // Es diferente
        println(myBool || myBool2) // Uno o el otro san verdaderos
        println(myBool && myBool2) // Los dos sean verdaderos

    }

    /*
    Aquí vamos a hablar de la Sentencia If
     */
    private fun sentenciaIf() {

        val myNumero = 10

        // OPERADORES Y CONDICIONALES
        // > mayor que
        // < menor que
        // >= mayor o igual que
        // <= menor o igual que
        // == igualdad
        // != desigualdad
        // OPERADORES LÓGICOS
        // && operador "y"
        // || operador "o"
        // !  operador "no"

        if (myNumero > 10) {
            println("$myNumero es mayor que 10")
        } else if (myNumero < 10) {
            println("$myNumero es menor que 10")
        } else {
            println("Si no se cumple ninguna de las condiciones anteriores, me ejecuto yo!")
        }
    }

    /*
    Aquí vamos a hablar de la Sentencia When
     */
    private fun sentenciaWhen() {

        // When con String
        var pais = "España"
        when (pais) {
            "España", "Mexico", "Perú", "Colombia", "Argentina" -> {
                println("El idioma es el Español")
            } "EEUU" -> {
            println("El idioma es el Inglés")
        } "Francia" -> {
            println("El idioma es el Frances")
        } else -> {
            println("No conozco el idioma")
        }
        }

        // When con Int
        var edad = 30
        when (edad) {
            0, 1, 2 -> {
                println("Eres un bebé")
            } in 3..10 -> {
            println("Eres un niño")
        } in 11..17 -> {
            println("Eres un adolescente")
        } in 18..69 -> {
            println("Eres adulto")
        } in 70..99 -> {
            println("Eres anciano")
        } else -> {
            println("o.o")
        }
        }
    }

    /*
    Aquí vamos a hablar de Arrays o Arreglos
     */
    private fun arrays() {

        val nombre = "Joan"
        val apellido = "Salmoral"
        val compania = "JSalmoralP"
        val edad = "30"

        // Creación de un Array
        val myArray = arrayListOf<String>()

        // Añadir datos de uno en uno
        myArray.add(nombre)
        myArray.add(apellido)
        myArray.add(compania)
        myArray.add(edad)
        myArray.add(edad)
        println(myArray)

        // Añadir un conjunto de datos
        myArray.addAll(listOf("Hola", "Que tal estas?", "Muy bien"))
        println(myArray)

        // Acceso a datos
        val myNombre = myArray[0]
        val myApellido = myArray[1]
        val myCompania = myArray[2]
        val myEdad = myArray[3]
        val myHola = myArray[5]
        val myComoEstas = myArray[6]
        val myBien = myArray[7]

        // Modificación de datos
        println(myArray[7])
        myArray[7] = "De fábula"
        println(myArray[7])

        // Eliminar datos
        println(myArray)
        myArray.removeAt(4)
        println(myArray)

        // Recorrer datos
        myArray.forEach {
            println(it)
        }

        // Otras operaciones
        println(myArray.count()) // Nos devuelve un numero con la cantidad de elementos de nuestro Array
        myArray.clear() // Borra todos los datos "elementos" de nuestro Array
        println(myArray.count())

        val myArrayPrimerElemento = myArray.first()
        val myArrayUltimoElemento = myArray.last()

        myArray.sort() // Ordenamos los elementos del Array por orden Alfabético
    }

    /*
    Aquí vamos a hablar de Mapas, también llamados Diccionarios
     */
    private fun mapas() {

        // Sintaxis
        var myMapa: Map<String, Int> = mapOf()
        println(myMapa)

        // Añadir elementos
        myMapa = mapOf("Joan" to 1, "Pedro" to 2, "Sara" to 5)
        println(myMapa)
        // Cuando añadimos elementos con "mapOf()" se borran los anteriores para añadir nuevos
        myMapa = mapOf("David" to 4, "Gerard" to 2, "Alex" to 10, "Jordi" to 20)
        println(myMapa)

        // Añadir un solo valor
        var myMapa2: Map<String, Int> = mapOf()
        myMapa2 = mutableMapOf("Cataleia" to 1, "Marta" to 2, "Doris" to 5)
        println(myMapa2)
        myMapa2["Ana"] = 7 // Añadimos un nuevo elemento
        println(myMapa2)
        myMapa2.put("María", 8) // Añadimos un nuevo elemento
        println(myMapa2)
        myMapa2.put("Cataleia", 50) // Modificamos un elemento (no pueden existir dos keys iguales)
        println(myMapa2)
        myMapa2.put("Joan", 50) // Añadimos un nuevo elemento (dos keys pueden tener el mismo valor)

        // Acceso a datos
        println(myMapa2["Joan"])

        // Eliminar datos
        myMapa2.remove("Doris")
        println(myMapa2)
    }

    /*
    Aquí vamos a hablar sobre los Loops, también llamados Bucles
     */
    private fun loops() {

        // BUCLES
        val myArray:List<String> = listOf("Hola", "Que tal estas?", "Muy bien")
        val myMapa:MutableMap<String, Int> = mutableMapOf("Joan" to 1, "Pedro" to 2, "Sara" to 5)

        // For
        for (myString in myArray) {
            println(myString)
        }
        for (myElemento in myMapa) {
            println("${myElemento.key} - ${myElemento.value}")
        }

        for (x in 0..10) { // Se imprimirá de 0 a 10 (11 veces en total)
            println(x)
        }
        for (x in 0 until 10) { // Se imprimirá de 0 a 9 (10 veces en total)
            println(x)
        }
        for (x in 0..10  step 2) { // Se imprimirá como el mismo anterior pero de dos en dos
            println(x)
        }
        for (x in 10 downTo 0 step 3) { // Se imprimirá del 10 al 0 dando saltos de 3
            println(x)
        }

        val myArrayNumerico = (0..10)
        for (myNumero in myArrayNumerico) {
            println(myNumero)
        }

        // While
        var x = 1
        while (x <= 10) {
            println(x)
            x++
        }
        while (x <= 10) {
            println(x)
            x += 2
        }
    }

    /*
    Aquí vamos a hablar de Seguridad contra Nulos
     */
    private fun nullSafety() {

        var myString = "JSalmoralP"
        //myString = null // Esto daría un error de compilación
        println(myString)

        // Variable Null Safety
        var mySafetyString: String? = "JSalmoralP 'Null Safety'"
        mySafetyString = null
        println(mySafetyString)
        mySafetyString = "Ahora es Null Safety"
        println(mySafetyString)

        // Forma tradicional de la comprobación
        /*if (mySafetyString != null) {
            println(mySafetyString!!) // Con el doble simbolo de admiración al final,
                                      // obligamos a que no sea nulo
        } else {
            println(mySafetyString)
        }*/

        // Safe call
        println(mySafetyString?.length) // Se va a jecutar el codigo hasta el interrogante,
        // mientras sea nulo, sino se ejecutará el código entero

        mySafetyString?.let { // Codigo que s ejecutará si, NO ES NULO
            println(it) // El "it" hace referencia a la parte antes del interrogante
            //println(mySafetyString!!)
        } ?: run { // Código que se ejecutará si, SI ES NULO
            println(mySafetyString)
        }
    }

    /*
    Aquí vamos a hablar de Funciones
     */
    private fun funciones() {

        diHola()
        diHola()
        diHola()

        diMiNombre("Joan")
        diMiNombre("Pedro")
        diMiNombre("Sara")

        diMiNombreYEdad("Joan", 30)

        val resultadoDeSumar: Int = sumaDeDosNumeros(10, 15)
        println(resultadoDeSumar)
        println(sumaDeDosNumeros(10, 10))
        println(sumaDeDosNumeros(10, sumaDeDosNumeros(10, 10)))
    }
    // Función Simple
    fun diHola() {
        println("Hola")
    }
    // Funciones con un parámetro de entrada
    fun diMiNombre(nombre: String) {
        println("Hola! Tu nombre es ${nombre}")
    }
    // Funciones con un parámetro de entrada
    fun diMiNombreYEdad(nombre: String, edad: Int) {
        println("Hola! Tu nombre es $nombre y tu edad es $edad")
    }
    // Funciones con un valor de retorno
    fun sumaDeDosNumeros(numero1: Int, numero2: Int) : Int {
        val suma: Int = numero1 +numero2
        return suma
    }

    /*
    Aquí vamos a hablar de Clases
     */
    private fun clases() {

        val joan = MyProgramadorClass(
            "Joan",
            30,
            arrayOf(
                MyProgramadorClass.Lenguaje.PHP,
                MyProgramadorClass.Lenguaje.HTML5,
                MyProgramadorClass.Lenguaje.CSS3,
                MyProgramadorClass.Lenguaje.Java,
                MyProgramadorClass.Lenguaje.Kotlin
            )
        )
        println("Hola mi nombre es " + joan.nombre)
        println("Y mi edad es ${joan.edad}")
        joan.edad = 100
        println("Ahora mi edad es ${joan.edad}")
        println(joan.yoSeProgramarEn())

        val sonia = MyProgramadorClass(
            "Sonia",
            30,
            arrayOf(
                MyProgramadorClass.Lenguaje.PHP,
                MyProgramadorClass.Lenguaje.HTML5,
                MyProgramadorClass.Lenguaje.CSS3,
                MyProgramadorClass.Lenguaje.Java
            ),
            arrayOf(joan)
        )
        println("Hola mi nombre es " + sonia.nombre)
        println("Y mi edad es ${sonia.edad}")
        println(sonia.yoSeProgramarEn())
        println("${sonia.amigos?.first()?.nombre} es amigo de ${sonia.nombre}")
    }
    // [END] KOTLIN NIVEL BÁSICO

    /**
     * KOTLIN NIVEL INTERMEDIO
     */
    /*
    Aquí vamos a hablar de las Clases Enumeradas, tambén conocidas como Enum Classes
     */
    enum class Direccion(val dir: Int) {

        NORTE(1), SUR(-1), ESTE(1), OESTE(-1);
        fun descripcion() : String {
            return when (this) {
                NORTE -> "La dirección es NORTE"
                SUR -> "La dirección es SUR"
                ESTE -> "La dirección es ESTE"
                OESTE -> "La dirección es OESTE"
                else -> "No sabemos la Dirección"
            }
        }
    }
    private fun enumClases() {

        // Asignación de valores
        var direccionDelUsuario: Direccion? = null
        println("Dirección del usuario: $direccionDelUsuario")

        direccionDelUsuario = Direccion.NORTE
        println("Dirección del usuario: $direccionDelUsuario")

        // Propiedades por defecto
        println("Propiedad 'name': ${direccionDelUsuario.name}") // Nos muestra el valor en String
        println("Propiedad 'ordinal': ${direccionDelUsuario.ordinal}") // Nos muestra la posición del valor

        // Funciones
        println(direccionDelUsuario.descripcion())

        //** Consejos
        //*** Solo funciona si la Clase Enumerada NO tiene parámetros
        // Creamos un Enum en base a su nombre en formato String
        ///EnumClass.valueOf(value:)
        //Retora un array con todos los valores posibles
        ///EnumClass.values()



    }

    /*
    Aquí vamos a hablar de las Nested e Inner Clases
    Trabajamos con el Archivo de:
        - MyNestedEInnerClass.kt
     */
    private fun nestedEInnerClases() {

        // Clase Anidada (Nested)
        val myNestedClass = MyNestedEInnerClass.MyNestedClass()
        val sumaDelNested = myNestedClass.suma(10,5)
        println("El resultado de la suma es $sumaDelNested")

        // Clase Interna (Inner)
        val myInnerClass = MyNestedEInnerClass().MyInnerClass()
        val sumaDelInner = myInnerClass.sumaMasDos(10)
        println("El resultado de la suma es $sumaDelInner")
    }

    /*
    Aquí vamos a hablar de la Herencia de Clases
    Trabajamos con los Archivos de:
        - PersonaClass.kt
        - ProgramadorClass.kt
        - DisenadorClass.kt
        - VeiculoInterface
     */
    private fun herenciaDeClases() {

        val joan = MyProgramadorClass(
            "Joan",
            30,
            arrayOf(
                MyProgramadorClass.Lenguaje.PHP,
                MyProgramadorClass.Lenguaje.HTML5,
                MyProgramadorClass.Lenguaje.CSS3,
                MyProgramadorClass.Lenguaje.Java,
                MyProgramadorClass.Lenguaje.Kotlin
            )
        )
        joan.trabajando()
        joan.irATrabajar()

        val pedro = MyDisenadorClass("Pedro", 20, "Photoshop")
        pedro.trabajando()
        pedro.editorUsado()
        pedro.irATrabajar()
        pedro.conducir()
    }

    /*
    Aquí vamos a hablar de las Intefaces
    Trabajamos con los Archivos de:
        - PersonaClass.kt
        - JuegoInterface.kt
     */
    private fun interfaces() {

        // No podemos llamar directamente una Interface a ser usada...
        //val jugador = JuegoInterface()

        val jugador = MyPersonaClass("Alex", 33)
        jugador.retransmitiendoEnVivo()
        jugador.jugar()
    }

    /*
    Aquí vamos a hablar de los Modificadores de Visibilidad
    Trabajamos con el Archivo de:
        - MyVisibilidadClass
     */
    private fun modificadoresDeVisiblilidad() {

        // Modificador de Visibilidad "Public"
        val vPublic = VisibilidadPublicClass()
        vPublic.nombrePublic = "Joan"
        vPublic.diMiNombrePublic()
    }
    // [END] KOTLIN NIVEL INTERMEDIO
}