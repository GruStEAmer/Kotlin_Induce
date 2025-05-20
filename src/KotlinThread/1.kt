package KotlinThread

fun main() {
    val (n,m) = readln().split(' ').map{ it.toInt() }
    val v:MutableList<List<Int>> = mutableListOf()
    val used:List<Boolean> = List(n) { false }
    for(i in 0 until m) {
        v.add(readln().split(' ').map { it.toInt() })
    }
}