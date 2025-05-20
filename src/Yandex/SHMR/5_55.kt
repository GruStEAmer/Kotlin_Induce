package Yandex.SHMR

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val s = reader.readLine()
    var ans = 0L
    var i = 0

    while(i < s.length){
        val r = i + 1
    }
    writer.write("$ans\n")
    reader.close()
    writer.close()
}