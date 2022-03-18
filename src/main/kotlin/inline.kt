inline fun doSomething(body : () -> Unit) {
    body()
}

fun callFunction() {
    doSomething { println("문자열 출력!") }
}

fun main() {
    callFunction()

    val prices = listOf(3000, 5000, 6000)
    prices.also {
        println("Total Price : ${it.sum()}")
    }
}