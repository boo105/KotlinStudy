fun main(args : Array<String>) {
    /* 코틀린은 3개의 구조적 점프 표현식이 있다.
    return 가장 인접한 둘러싸인 함수 또는 익명 함수로부터 반환
    break  가장 인접한 둘러싸인 반복 종료
    continue 가장 인접한 둘러싸인 반복의 다음 단계 진행 =
    * */

    // break와 label
    // label은 식별자로 @를 사용한다. ex) abc@, fooBar@
    // 약간 c언어 goto 랑 비슷한듯?
    loop@ for (i in 1..100) {
        println("i : ${i}")
        for(j in 1..100) {
            println("j : ${j}")
            // 라벨이 붙여진 break는 loop@가 표시된곳으로 이동후 break 실행함
            if(j == 3)
                break@loop

        }
    }
    println("벗어나기 완료!")

    foo()

    // 값을 리턴할 때 파서는 자격이 있는 리턴에 우선권을 부여함.
    val num = run a@ {
        // innerNum은 반환을 받지 못함
        val innerNum = run {
            return@a 1
        }
        println("testNum : ${innerNum}")
    }

    println(num)

}

// label에서 return
fun foo() {
//    listOf(1, 2, 3, 4, 5).forEach lit@{
//        if(it == 3)
//            return@lit
//        println(it)
//    }

    // 람다 표현식 내에 함수를 라벨 이름으로 사용할 수있다!!!!!!!!
    listOf(1, 2, 3, 4, 5).forEach {
        if(it == 3)
            return@forEach
        println(it)
    }
    println("done with explicit label")
//
//    run loop@{
//        listOf(1, 2, 3, 4, 5).forEach {
//            if (it == 3)
//                return@loop // 람다 표현식을 지나 run 위치에서 리턴
//            println(it)
//        }
//    }
//    println("done with nexted loop")
}