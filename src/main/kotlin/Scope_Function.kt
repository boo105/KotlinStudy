import kotlin.random.Random

data class Person (val name : String, var age : Int)

fun main(args : Array<String>) {
    val person = Person("홍길동", 30)
    /* let, run, with은 람다식 결과를 반환
    * */

    // this로 참조
    person.run {
        println("이름 : ${name}")
        println("이름 : ${this.name}")
    }

    // it으로 참조
    person.let {
        println("이름 : ${it.name}")
    }

    // 혹은 전달 인자명을 직접 지정할 수 있음.
    person.let { value ->
        println("이름 : ${value.name}")
    }


    /* apply, also는 Context Object를 반환
    *  따라서 체인 형식으로 계속적인 호출이 가능함
    * */

    val numberList = mutableListOf<Double>()
    numberList.also { println("Population the list") }
        .apply {
            add(2.71)
            add(3.14)
            add(1.0)
        }
        .also { println("Sorting the list") }
        .sort()

    // 따라서 Context Object를 반환하는 함수의 return문에도 사용 가능.
    fun getRandomInt() : Int {
        return Random.nextInt(100).also {
            println("getRandomInt() generated value $it")
        }
    }
    val i = getRandomInt()

    /* let, run, with은 람다식 결과를 반환하기 때문에
    * 결과를 변수에 할당하거나
    * 결과에 대해 추가적인 작업 등을 수행할 때 사용할 수 있습니다.
    * */
    val numbers = mutableListOf("one", "two", "three")
    val addNumberList = numbers.run {
        add("four")
        add("five")
    }

    // 반환 값을 무시하고 바로 람다식을 사용하여, 임시 범위를 만들어서 사용할 수도 있습니다.
    with(numbers) {
        val firstItem = first()
        val lastItem = last()
        println("첫번째 항목: $firstItem, 마지막 항목: $lastItem")
    }

    // let : 객체 결과값에 하나 이상의 함수를 호출하는 경우 사용함.
    /** let 안썼을 때 */
    var numbers2 = mutableListOf("one", "two", "three", "four", "five")
    val resultList = numbers2.map { it.length }.filter { it > 3 }
    println(resultList)

    /** let 사용 시 */
    numbers2 = mutableListOf("one", "two", "three", "four", "five")
    numbers2.map { it.length }.filter { it > 3 }.let {
        println(it)
        // 추가적인 함수 호출 가능
    }

    // with : 이미 생성된 Context Object 객체를 인자로 받아서 사용하는 것이
    // 효율적일 때는 with을 사용함.
    val numbers3 = mutableListOf("one", "two", "three")
    with(numbers3) {
        println("'with' 는 ${this} 로 참조합니다.")
        println("${size}개의 요소를 포함합니다.")
    }

    // run : with이랑 비슷한 역할로,
    // 이미 생성된 Context Object 객체를 사용할 때 호출하며, with와는 전달받는 위치가 다릅니다.
    // 그리고 가장 중요한 차이점은 앞에 Safe Call (?.)을 붙여서 null 체크까지 할 수 있기 때문에,
    // with보다는 run이 더 자주 사용되는 이유 중 하나라고 할 수 있습니다.
    data class Point(val x : Double)
    /** 기본 코드 */
    val point = Point(2.1)
    val width = point.x * 0.5

    /** run() 사용 코드 */
    val width2 = run {
        val point2 = Point(2.1)
        point2.x * 0.5
    }

    val point3 = Point(2.1)
    val width3 = point3.run {
        x * 0.5
    }

    // apply는 보통 객체 초기화 시에 가장 많이 사용함.
    val person2 = Person("홍길동", 0).apply {
        age = 30
    }

    // also는 기존 객체를 수정하거나 변경하지 않고,
    // 디버깅을 위한 로깅 등의 추가적인 부가 작업을 하려고 할 때 사용합니다.
    val numbers4 = mutableListOf("one", "two", "three")
    numbers4
        .also { println("새 항목 추가하기 전 리스트 요소들: $it") }
        .add("four")
}