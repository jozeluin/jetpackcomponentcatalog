package com.example.jetpackcomponentcatalog.ui
fun main() {
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(false, cupcake)
    treatFunction()
    trickFunction()

    val operacion={a:Int->a % 2==0}
    println(operacion(6))
}
fun trickOrTreat(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        println(extraTreat(5))
        return treat
    }
}
val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}


