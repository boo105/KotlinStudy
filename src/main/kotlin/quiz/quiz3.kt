package quiz

fun createLotto() : List<Int> {
    return (1..45).shuffled().take(7)
}

fun printLotto(balls : List<Int>) {
    // 마지막 번호는 보너스 번호.
    balls.forEachIndexed { index, ball ->
        if(index == balls.size - 1)
            print("+ " + ball)
        else
            print(ball.toString() + " ")
    }
}

fun main() {
    for(i in 1..5) {
        val balls : List<Int> = createLotto()

        println("-- ${i}회차 로또 번호 --")
        printLotto(balls)
        println()
    }
}