import kotlinx.coroutines.*

fun main(args : Array<String>) {
    /*
    * 동기처럼 보이는 코드로 비동기 동작을 수행할수 있다!
    * 코루틴
    * 1. 협력형 멀티태스킹
    * 2. 동시성 프로그래밍 지원
    * 3. 비동기 처리 도와줌
    *
    * 사용비용이 매우 저렴함 (Thread와 비교했을때)
    *
    * */

    // 기본적으로 코루틴은 shared pool of threads에서 구동
    // launch{} : 반환값이 없는 Job 객체
//    println("Start")
//    GlobalScope.launch {
//        // 만약 3초를 기다린다고 가정하면 Hello는 출력안됨 (메인 쓰레드가 먼저 종료되므로)
//        delay(1000) // 쓰레드가 아닌 코루틴 동작 일시 정지
//        println("Hello")
//    }
//
//    Thread.sleep(2000)  // Thread 자체를 중단
//    println("Stop")


    // 비동기 : 코루틴으로부터 값 받기
    // async{} 에서 await()은 코루틴의 결과를 반환하는 Deferred<T> 값을 반환
    // async : 반환값이 있는 Deferred 객체
//    val deferred = (1..100).map { n ->
//        GlobalScope.async {
//            n
//        }
//    }
//
//    runBlocking {
//        val sum = deferred.map {
//            println(it.await().toLong())
//            it.await().toLong()
//        }.sum()
//
//        println(sum)
//    }

    // suspend 함수는 코루틴에서 호출 가능 하고 함수 내부에서는 비동기 코드 작동가능
    GlobalScope.launch {
        var k = workload(100)
        print(k)
    }
    // 코루틴이 전부 수행되기전에 메인 쓰레드가 종료되서 출력못하는 상황을 방지하는 용도
    runBlocking {
        delay(2000)
    }
    // + runBlocking{} 은 코루틴이 전부 실행될떄까지 메인루틴을 잠시 대기시켜줌

    // Job.join() : Job의 실행이 끝날때까지 대기하는 함수
    // Deferred.await() : Deferred의 실행이 끝날때까지 대기하는 함수
    // cancle() 함수로 코루틴 취소도 가능함.
    /* + withTimeoutOrNull 라는 blocking 함수는
    * 수행시간 내에 전부 수행하지 못하면 null을 반환함.
    * */
    runBlocking {
        var result = withTimeoutOrNull(50) {
            for(i in 1..10) {
                println(i)
                delay(10)
            }
            "Finish"
        }
        println(result)
    }
}

suspend fun workload(n : Int) : Int {
    delay(1000)
    return n
}