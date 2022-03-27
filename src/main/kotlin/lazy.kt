fun main() {
    lateinit var text: String

    val textLength: Int by lazy {
        text.length
    }

    // 늦은 초기화!
    text = "Hello World!"
    println(textLength)
}