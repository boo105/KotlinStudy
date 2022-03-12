package quiz

data class PredictLotto (val lotto : List<Int>)

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

fun getLottoRank(predictLotto: List<Int>, answerLotto : List<Int>) : Int {
    var count = 0;

    for(lottoNumber in predictLotto) {
        val findNumber = answerLotto.find {
            it == lottoNumber
        }

        findNumber?.let { count++ }
    }

    val rank = when(count) {
        6 -> {
            val bonusNumber = answerLotto.get(answerLotto.size - 1)
            val findBonusNumber = predictLotto.find { it == bonusNumber }
            findBonusNumber?.let { 2 } ?: 1
        }
        5 -> 3
        4 -> 4
        3 -> 5
        else -> -1
    }

    return rank
}

fun main() {
    val predicts : List<PredictLotto> = listOf(
        PredictLotto(listOf(1,6,12,34,36,41)),
        PredictLotto(listOf(1,7,13,22,31,43)),
        PredictLotto(listOf(1,10,18,25,34,38)),
        PredictLotto(listOf(2,11,14,16,25,38)),
        PredictLotto(listOf(2,11,16,18,27,40)),
        PredictLotto(listOf(4,7,12,27,35,44)),
        PredictLotto(listOf(4,7,17,26,36,44)),
    )


    for(i in 1..40) {
        val balls : List<Int> = createLotto()

//        val rankOne = balls.take(6)
//        val rankTwo : MutableList<Int> = mutableListOf()
//        rankTwo.add(balls.get(balls.size - 1))
//        for(number in balls.take(6).shuffled().take(5)) {
//            rankTwo.add(number)
//        }


        println("-- ${i}회차 로또 번호 --")
        printLotto(balls)
        println()
        predicts.forEachIndexed { index, predictLotto ->
            val rank = getLottoRank(predictLotto.lotto, balls)
            if (rank != -1)
                println("${index + 1}번째 번호 : ${rank}등")
            else
                println("${index + 1}번째 번호 : 낙첨")

        }
//        println(rankOne)
//        println(rankTwo)
//        println("rankOne : ${getLottoRank(rankOne, balls)}등")
//        println("rankTwo : ${getLottoRank(rankTwo, balls)}등")
    }
}