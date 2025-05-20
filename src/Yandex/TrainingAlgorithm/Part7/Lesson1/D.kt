package Yandex.TrainingAlgorithm.Part7.Lesson1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n,m) = reader.readLine().split(' ').map{
        it.toInt()
    }
    val l = reader.readLine().split(' ').map {it.toInt()}
    val b = BooleanArray(m+1) { false }
    b[0] = true
    for(i in l){
        var j = m
        while(j >= 0){
            if(b[j]){
                if(j + i <= m){
                    b[i + j] = true
                }
            }
            j--
        }
    }
    var j = m
    while(!b[j]) j--
    println("$j")

    writer.close()
    reader.close()
}