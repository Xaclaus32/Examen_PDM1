package com.pdm.ud1_examen_xavier_nicolaukt

import java.util.Scanner


fun main() {


    println("El plato pagado por la suma de 5.5 es:"+Costedeplatos(5.5))
    println("El plato pagado por la suma de 7 es:"+Costedeplatos(7.0))
    println("El plato pagado por la suma de 16 es:"+Costedeplatos(16.0))
    println("-----------------------------------------------------------------------------------------------------")
    gestionar_reserva(1);
    gestionar_reserva(8);
    println("-----------------------------------------------------------------------------------------------------")
    Mostrar_reserva("Luis","23:45",22,8,2024,true )
    Mostrar_reserva("Luis","23:45",22,8,2024,false )
    println("-----------------------------------------------------------------------------------------------------")


    procesarReserva(8,"Juan","12:00",5,6,2023,true)
}


fun Costedeplatos(coste: Double): String {
    return when (coste) {
        in 0.0..5.0 -> "Muy barato"
        in 5.5..8.0 -> "Barato"
        in 8.5..15.0 -> "Normal"
        in 15.5..21.5 -> "Caro"
        in 22.00..100.0 -> "Muy Caro"
        in 100.0..999.0 -> "Carisimo"
        else -> "Número no válido, no existe"
    }
}


fun gestionar_reserva(elegir_mesa :Int): Boolean {//habia que pasar por parametro la lista,el for un poco mal.


    val mesasLibres = mutableListOf(1, 2, 3, 4, 5, 6, 7, 3, 3, 3, 4, 5)




        for (i in 0 until mesasLibres.size) {
            if (mesasLibres[i] == elegir_mesa) {
                mesasLibres.removeAt(i)
                println("Reserva confirmada. " + "\n" + "Mesas libres restantes: $mesasLibres")
                return true
            } else
                println("No se encontró una mesa adecuada para $elegir_mesa Personas.")
            return false

        }

return true
    }


    fun Mostrar_reserva(
        Nombre: String,
        Hora: String,
        dia: Int,
        mes: Int,
        anyo: Int,
        reserva: Boolean) {
        // val Nombre:String? = null // permitimos que sea null
        //val  Hora:String? = null
        val scan = Scanner(System.`in`)
        println("Hola Buenas, le gustaria hacer una reserva?")
        if (reserva == false) {
            println("Por lo visto no quiere reserva")
        } else
            println(
                "Se va a reservar al nombre de " + Nombre + "  A la Hora :" + Hora +
                        "  El dia : " + dia + "  En el mes : " + mes + " En el año :" + anyo
            )


    }

        fun procesarReserva(
            comensales: Int?,
            nombre: String?,
            hora: String?,
            dia: Int?,
            mes: Int?,
            anyo: Int?,

            confirmacion: Boolean
        ): String {
            if (comensales == null || nombre == null || hora == null || dia == null || mes == null || anyo == null) {
                return "Error: uno de los parámetros es null."
            }

            val gestionado = gestionar_reserva(comensales)
            val reserva = Mostrar_reserva(nombre,hora,dia,mes,anyo,confirmacion)

            return if (gestionado) {
                "Reserva procesada\n$reserva\nMesa asignada para $comensales comensales."
            } else {
                "Reserva procesada\n$reserva\nNo se encontró una mesa adecuada para $comensales comensales."
            }

        }


