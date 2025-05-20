package Yandex.TrainingAlgorithm.Part7.Lesson3

fun main() {
    val (x1,c1) = readln().split(' ').map { it.toInt() }
    val (x2, y2) = readln().split(' ').map { it.toInt() }

    val ans1 = x1.xor(c1)
    val ans2 = x2.xor(y2)

    println("$ans1")
    println("$ans2")
}