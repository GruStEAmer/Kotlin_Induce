package Yandex.YandexCodeRun

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val set = mutableSetOf<String>()

    val read = reader.readLines()
    for(i in read) {
        val r = i.trim().split("\\s+".toRegex())
        for(j in r) set.add(j)
    }
    println(set.size)
    reader.close()
    writer.close()
}