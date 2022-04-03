data class Point(val x : Int, val y : Int, val z : Int)

fun main() {
    val point = Point(1, 2, 3)
    val (x, y, z) = point
    println(x)
    println(y)
    println(z)
}