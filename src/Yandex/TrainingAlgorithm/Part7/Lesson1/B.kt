package Yandex.TrainingAlgorithm.Part7.Lesson1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = reader.readLine().toInt()
    for(i in 0 ..< t) {
        val n = reader.readLine().toInt()
        val l = reader.readLine().split(' ').map {it.toInt()}


        var ans:MutableList<Int> = mutableListOf()
        var counter = 0
        var mn = 2 * 100000
        for(i in 0 until l.size) {
            if(l[i] < mn) mn = l[i]
            if(counter + 1 > mn) {
                ans.addLast(counter)
                counter = 0
                mn = l[i]
            }

            counter++
        }
        if(counter != 0) ans.addLast(counter)
        println(ans.size)
        for(i in ans) print("$i ")
        println()
    }

    reader.close()
    writer.close()
}