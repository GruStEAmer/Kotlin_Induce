package Classes

class Student(private val name: String) {
    init{
        println("$name")
    }
    constructor(sec:String, id: Int): this(sec) {

    }
}

fun main() {
    val s = Student("rer").apply {
        Student("s")
    }
    val s2 = Student("rer").let {
        Student("s")
    }
    println(s == s2)
}