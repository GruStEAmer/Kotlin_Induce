package Yandex.TrainingAlgorithm.Part7.Lesson3

fun main() {
    val n = readln().toInt()
    val bl: List<String> = readln().split(' ').map{ it.toLong().toString(2) }

    var sum = 0
    for(i in 1..< bl.size){
        val x = bl[i].count { it == '1'}
        println(bl[i])
        sum = (sum + x) % 2
    }
    println(sum)
}