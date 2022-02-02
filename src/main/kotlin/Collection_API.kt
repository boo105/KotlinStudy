fun main(args : Array<String>) {

    // collection 중 하나인 list
    // 코틀린은 불변과 가변이 존재함 ex) listOf, mutableListOf
    // 불변 : 정의 이후로 변경 불가능
    // 가변 : 쓰기 기능 포함. (변경 가능)
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    /* filter : 컬렉션을 iteration 하면서 주어진 람다에 각 원소를 넘겨서 람다가
    * true를 반환하는 원소만 필터링하는 기능을 합니다.
    * filter의 결과는 주어진 조건문제 만족하는 원소만으로 이루어진 새로운 컬렉션 입니다!!
    * */
    print("filter의 결과 : ")
    println(list.filter { it % 2 == 0})

    /* map : 각 원소를 원하는 형태로 변환하는 기능,
    * map의 결과는 새로운 컬렉션
    * apply랑 같은 기능인거같기도 하고??
    * */
    print("map의 결과 : ")
    println(list.map { it * it })

    // 컬렉션 조건 함수
    /* all : 컬렉션의 모든 원소가 조건을 만족하는지 판단, 반환 -> Boolean
    * any : 컬렉션의 원소 중에, 조건을 만족하는 원소가 하나라도 있는지 판단, 반환 -> Boolean
    * count : 조건을 만족하는 원소의 개수를 반환, 반환 -> int
    * find : 조건을 만족하는 첫번째 원소를 반환, 반환 -> <T>
    * */
    print("all의 결과 : ")
    println(list.all { it < 30 })

    print("any의 결과 : ")
    println(list.any { it < 3 })

    print("count의 결과 : ")
    println(list.count { it > 3 })

    // find는 만족하는 원소가 없으면 null을 반환.  firstOrNull이랑 비슷?
    print("find의 결과 : ")
    println(list.find { it > 7 })

    // groupBy : 컬렉션의 모든 원소를 어떤 특성에 따라 여러 그룹으로 나누고 싶을때 사용.
    // groupBy의 결과는 Map<Int, List<Person>>이 됨.
    // groupby를 위한 클래스
    data class Person(val name : String, val age : Int)
    val people = listOf(
        Person("홍길동", 26),
        Person("강민호", 30),
        Person("개복치", 30),
    )

    print("groupBy의 결과 : ")
    println(people.groupBy { it.age })

    /* flatMap은 주어진 람다를 컬렉션의 모든 객체에 적용하고,
    *  그 결과로 얻어지는 여러 리스트들을 한 리스트로 flat하게 만드는 함수임.
    * 즉 리스트안에 리스트들을 처리할때 쓰는 함수이다.
    * */
    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    // flatten 함수는 특별히 변환해야 할 내용이 없으면 리스트 안에 리스트를 flat하게 만듬.
    val list2 = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
    println(list2.flatten())

    // 번외 : sequence
    // 자바8의 stream처럼 연산하려면 asSequence를 사용하면 된다고 한다.
    // sequence를 사용하면 중간 연산를 실행하지 않는 장점이 있기 때문에,
    // 원소의 수가 많을때 사용하면 속도나 메모리면에서 훨씬 좋은 성능을 만들수 있습니다.
    // 참조 : https://developer88.tistory.com/182
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
}