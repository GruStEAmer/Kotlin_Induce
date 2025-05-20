package Yandex.TrainingAlgorithm.Part7.Lesson3


fun main() {
    val n = readln().toInt()
    val matrix = Array<IntArray>(n) {
        IntArray(n) { 0 }
    }
    for(i in 0..<n){
        val r = readln().split(' ').map {it.toInt()}
        for(j in 0..<n){
            matrix[i][j] = r[j]
        }
    }
    val ans = Array<Int>(n) { 0 }
    for(i in 0..< n){
        var a = 0
        for(j in 0 ..< n){
            a = a.or(matrix[i][j])
        }
        ans[i] = a
    }
    for(i in ans) print("$i ")
}