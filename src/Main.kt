fun algoritmoDescifrado(textoCifrado: String, claveDescifrado: Int): String {
    val alfabeto = ('a'..'z').joinToString("")
    var textoPlano = ""

    for (letra in textoCifrado) {
        if (letra !in alfabeto) {
            textoPlano += letra
        } else {
            val indiceLetraCifrada = alfabeto.indexOf(letra)
            var indiceLetraDescifrada = indiceLetraCifrada - claveDescifrado

            if (indiceLetraDescifrada < 0) {
                indiceLetraDescifrada += alfabeto.length
            }
            textoPlano += alfabeto[indiceLetraDescifrada]
        }
    }

    return textoPlano
}

fun algoritmoCifrado(textoPlano: String, claveCifrado: Int): String {
    val alfabeto = ('a'..'z').joinToString("")
    var textoCifrado = ""

    for (letra in textoPlano) {
        if (letra !in alfabeto) {
            textoCifrado += letra
        } else {
            val indiceLetraPlana = alfabeto.indexOf(letra)
            var indiceLetraCifrada = indiceLetraPlana + claveCifrado

            if (indiceLetraCifrada >= alfabeto.length) {
                indiceLetraCifrada -= alfabeto.length
            }

            textoCifrado += alfabeto[indiceLetraCifrada]
        }
    }

    return textoCifrado
}

fun main() {
    var opcion=0;
    do {
        println("""MENU TEXTOS CIFRADOS
            |INGRESE EL NUMERO SEGUN LA OPCION QUE NECESITE:
            |1. Decifrar un texto
            |2. Cifrar un texto
            |3. Salir
        """.trimMargin())
        opcion = readln().toInt()

        when(opcion){
            1->{
                print("Por favor introduce el texto cifrado: ")
                val textoCifrado = readLine()!!.toLowerCase()

                print("Por favor ingrese la clave de descifrado: ")
                val claveDescifrado = readLine()!!.toInt()

                val textoPlano = algoritmoDescifrado(textoCifrado, claveDescifrado)
                println(textoPlano)
            }
            2->{
                print("Por favor introduce el texto plano: ")
                val textoPlano = readLine()!!.toLowerCase()

                print("Por favor ingrese la clave de cifrado: ")
                val claveCifrado = readLine()!!.toInt()

                val textoCifrado = algoritmoCifrado(textoPlano, claveCifrado)
                println("Texto cifrado: $textoCifrado")
            }
            3->{
                println("Gracias por usar el sistema de Cifra y Decifrado Cesar 8)")
            }
        }
    }while (opcion!=3)


}