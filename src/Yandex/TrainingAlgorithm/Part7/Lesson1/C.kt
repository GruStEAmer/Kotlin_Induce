package Yandex.TrainingAlgorithm.Part7.Lesson1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    var n = reader.readLine().toLong()
    var two = 1L
    val l: List<Pair<Long, Long>> = reader.readLine().split(' ').map {
        two *= 2
        Pair(two/2, it.toLong())
    }.sortedBy { it.first.toDouble()/it.second.toDouble()}

    var m = 0L
    var totalM = LongArray(l.size) { 10000000 }
    for(i in 0 until l.size) {
        val s = n / l[i].second
        n -= l[i].second * s
        m += l[i].first * s
        totalM[i] = m + l[i].first
    }

    for(i in totalM){
        if(m > i) m = i
    }
    println("$m")

    reader.close()
    writer.close()
}