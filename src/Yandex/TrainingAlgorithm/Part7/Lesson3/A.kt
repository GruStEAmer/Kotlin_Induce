package Yandex.TrainingAlgorithm.Part7.Lesson3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    var x = reader.readLine().trim().toLong()
    var counter = 0L
    while(x != 0L){
        counter += x % 2
        x /= 2
    }
    writer.write("$counter")

    reader.close()
    writer.close()
}