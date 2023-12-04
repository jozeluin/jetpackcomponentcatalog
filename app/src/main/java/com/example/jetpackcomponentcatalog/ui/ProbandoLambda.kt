package com.example.jetpackcomponentcatalog.ui

fun main() {
    var selected: Int = 0


    prueba(selected) { selected += it }
    print("Estoe es lo que da selected 1 $selected")
    prueba(selected) { selected += it }
    print("Estoe es lo que da selected 2$selected")

}


fun prueba(sele: Int=0, function: (Int) -> Unit) {
    print("Esto es el primer print ." + sele + siesdos(function(2)))
    print( siesdos(function(2)))






    return
}

fun siesdos(function: Unit) {
    function()
    print("Estoy en dos ")
    return
}

fun function():Int {
   return 10
}

fun siestres(): Int {
    return 3

}

fun siescuatro(): Int {
    return 4
}