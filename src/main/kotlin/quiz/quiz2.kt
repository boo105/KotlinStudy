data class User(val name: String, val age: Int)

val users = listOf(
    User("Alice", 16),
    User("Bob", 10),
    User("Carol", 20),
    User("Dave", 32),
    User("Eve", 29),
    User("Frank", 21),
    User("Grace", 41)
)

fun List<User>.findUserNamesOverThisAgeDesc(age: Int): List<String> {
    val usersOverAge = users
        .filter { it.age >= age }
        .map { it.name }
        .sorted()
        .reversed()

    return usersOverAge
}

fun main() {
    val queryAge = readlnOrNull()?.toIntOrNull()

    val userNames = users.findUserNamesOverThisAgeDesc(queryAge ?: 0)
    userNames.forEach {
        println(it)
    }
}