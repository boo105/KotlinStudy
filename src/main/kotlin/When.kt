interface Expr
class Num(val value : Int) : Expr
class Sum(val left : Expr, val right : Expr) : Expr

enum class Color(
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238); // need semicolon

    fun rgb() = (r * 256 + g) * 256 + b
}

sealed class FontColor {
    object Red : FontColor()
    object Green : FontColor()
    object Blue : FontColor()
}

fun main() {
    val num = readlnOrNull()?.toIntOrNull()

    // 스마트 캐스트 is로 검사하게 되면
    when(num) {
        1 -> println("1를 입력받았습니다!")
        2 -> println("2를 입력받았습니다!")
        3, 4 -> println("3 또는 4를 입력받았습니다!")
        in 5..10 -> println("5와 10 사이에 숫자를 입력받았습니다!")
        // is Price -> println("가격 : ${num.value} , 할인율 : ${num.discountRate}")
        else -> println("예외적인 숫자 입력!")
    }

    fun eval(e : Expr) : Int =
        when(e) {
            is Num -> e.value
            is Sum -> eval(e.left) + eval(e.right)
            else -> throw  java.lang.IllegalArgumentException("Unknown")
        }

    println(eval(Sum(Sum(Num(1), Num(2)), Num(5))))

    //when에 아무 인자도 없다.
    num?.let {
        when {
            (it >= 90) -> println("A")
            (80 <= it && it < 90) -> println("B")
            (70 <= it && it < 80) -> println("C")
            else -> println("F")
        }
    }

    when(Color.BLUE) {
        Color.RED -> println("Richard")
        Color.ORANGE -> println("Of")
        Color.YELLOW -> println("York")
        Color.GREEN -> println("Gave")
        Color.BLUE -> println("Battle")
        Color.INDIGO -> println("In")
        Color.VIOLET -> println("Vain")
    }

    val fontColor : FontColor = FontColor.Red
    // 기본적으로는 warning으로 표시되지만 progressiveMode 값을 True로 설정하면 오류 발생합니당
    when(fontColor) {
        FontColor.Red -> println("Noto Sans")
        FontColor.Green -> println("Open Sans")
        // 에러 없음 하지만 FontColor 확장 시 경고 혹은 컴파일 에러 발생
    }
}