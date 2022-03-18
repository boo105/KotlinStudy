infix fun String.add(other : String): String {
    return this + other
}

fun main() {
    val price = "3000"
    println(price add "원")
}