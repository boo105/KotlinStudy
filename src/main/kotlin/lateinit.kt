fun main() {
    lateinit var text : String

    val result = 30

    text = "Result : $result"
    println(text)

    val number = 50
    text = "Result : ${result + number}"
    println(text)
}