package Yandex.TrainingAlgorithm.Part7.Lesson1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = reader.readLine().split(' ').map {it.toInt()}

    var k = 1
    var xx = reader.readLine()
    if(xx[xx.length-1] == ' ') xx = xx.dropLast(1)
    val x = xx.split(' ',limit = n).map{
        Pair(k++,it.toInt())
    }.sortedWith { a, b -> b.second - a.second}
    k = 1
    var yy = reader.readLine()
    if(yy[yy.length-1] == ' ') yy = yy.dropLast(1)
    val y = yy.split(' ', limit = m).map{ Pair(k++,it.toInt()) }.sortedWith { a, b -> b.second - a.second}

    val ans = IntArray(n + 1) { 0 }

    var i = 0
    var j = 0
    var counter = 0
    while(i < n) {
        if(x[i].second < y[j].second){
            ans[x[i].first] = y[j].first
            j++
            counter++
        }
        else {
            ans[x[i].first] = 0
        }
        i++
    }
    println("$counter")
    for(s in 1 until ans.size) print("${ans[s]} ")
    reader.close()
    writer.close()
}