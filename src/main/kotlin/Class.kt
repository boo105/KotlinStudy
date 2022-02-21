// 파라미터 기본값을 설정하여 생성자 오버로드를 안만들어도 됨.
// 생성자 키워드를 생략한 형태
// class 구현이 너무 가독성이 좋아짐!!!
// 내부적으로 getter setter 생성이됨.
// 이떄 val은 geteer만 생성, var은 getter, setter 둘다 생성
class Person2(val name : String = "홍길동", val age : Int = 20) {
    val isTeen : Boolean
    get() =
        age < 20

//    constructor(name : String, age : Int) {
//        this.name = name
//        this.age = age
//    }
//    var name : String = ""
//    var age : Int = 0
}

// POJO 만들때 딱맞는놈!!!!!!!!
// getter, setter, toString, hashCode, equals 등 자동으로 만들어줌 대박!
data class HandSomeGuy(
    val name : String,
    val age : Int,
    val job : String
)

// 싱글톤
// 생성자를 못가짐... ㅠㅠ
// thread-saft 하게 처리됨.  와 대박!!
object GameManager {
    val title : String = ""
    val type : String = ""
}

// 클래스내 Companion object는 딱 하나만 쓸수있음.
class Car(val horsepowers: Int) {
    companion object Factory {
        val cars = mutableListOf<Car>()

        fun makeCar(horsepowers: Int): Car {
            val car = Car(horsepowers)
            cars.add(car)
            return car
        }
    }
}

fun main() {
    val p1 = Person2("민호")
    val p2 = Person2()

    println("${p1.name} : ${p1.age}, isTeen : ${p1.isTeen}")
    println("${p2.name} : ${p2.age}, isTeen : ${p2.isTeen}")

    // Factory 객체 생략가능
    val car = Car.makeCar(150)
    val car2 = Car.Factory.makeCar(150)
    println(Car.cars.size)
}