package es.jsalmoralp.apuntesandroidstudio

interface MyJuegoInterface {
    /* INTERFACES
    Pueden contener DECLARACIONES ABSTRACTAS o IMPLEMENTACIONES de funciones o propiedades.
    La diferencia con las clases abstractas es que las interfaces NUNCA pueden almacenar un estado.
    Y en estas no hace falta declarar que una función es abstracta,
        ya que por todas las funciones lo són,
        ya que la unica forma de implementar una Interface es en una Clase.
    Tampoco se puede implementar un constructor, ya que no pueden almacenar datos.
     */

    val juego: String
    /*
    // Esto no se puede hacer ya que no puede almacenar datos
    /->
    val juego: String = "Donkey Kong"
    <-/
    // La unica forma sería la siguiente, ya que más que asignar un valor,
    // es como una función que devuelve un string ...
    /->
    val juego: String
        get() = "Donkey Kong"
    <-/
     */

    // Nos permite declarar funciones que después serán obligadas a implementarse en su herencia
    fun jugar()
    // También incluso podemos implementar ya un comportamiento en la función,
    // de esta manera no será obligada su implementación
    fun retransmitiendoEnVivo() {
        println("Estoy retransmitiendo en vivo mi juego de $juego")
    }
}