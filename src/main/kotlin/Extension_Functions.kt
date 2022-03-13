fun List<Int>.getHigherThan(num : Int) : List<Int> {
    val result = arrayListOf<Int>()
    for(item in this) {     // this는 자기자신(여기서는 numbers를 뜻함)
        if(item > num) {
            result.add(item)
        }
    }
    return result
}

// Generic 타입에 관해서도 확장이 가능하다.
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

class Test {
    fun solution(char : Char) {
        println("안녕")
    }

    fun solution2(int : Int) {
        println("반가워")
    }
}

// Test 클래스 안의 멤버 함수인 solution과 이름은 같지만 매개변수 타입이 달라 구분 가능
fun Test.solution(int : Int) {
    println("잘가")
}

// Test 클래스 안의 멤버 함수인 solution2와 이름도 같고 매개변수 타입도 같아 구분 불가능
fun Test.solution2(int : Int) {
    println("또봐")
}

class NewList : ArrayList<Int>() {
    fun getHigherThan(num: Int): List<Int> {
        val result = arrayListOf<Int>()
        this.forEach { it->
            if (it > num) {
                result.add(it)
            }
        }
        return result
    }
}

fun main() {
    val numbers : List<Int> = listOf(1, 2, 3, 4, 5, 6)
    val filtered = numbers.getHigherThan(3).toString()
    println(filtered)

    val testList = mutableListOf("A", "B", "C")
    // swap() 함수 호출
    testList.swap(0, 2)
    println(testList)

    val numbers2 = NewList()
    numbers2.add(1)
    numbers2.add(2)
    numbers2.add(3)
    numbers2.add(4)
    numbers2.add(5)
    numbers2.add(6)
    val filtered2 = numbers2.getHigherThan(4).toString()
    println(filtered2)

    // 확장 함수는 멤버 함수를 오버로딩 할 수는 있다.
    Test().solution('c')
    Test().solution(1)
    Test().solution2(3)  // 확장 함수 호출되지 않고 멤버 함수가 호출.
}

