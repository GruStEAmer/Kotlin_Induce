package Yandex.YandexCodeRun

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    var sum_n = 0
    val parts = reader.readLine().split(" ")
    for(i in 0..<n){
        sum_n += parts[i].toInt()
    }
    writer.write("${100/sum_n}")

    reader.close()
    writer.close()
}