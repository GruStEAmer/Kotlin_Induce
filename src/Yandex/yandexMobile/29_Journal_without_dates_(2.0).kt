//Недоделал
package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val l: MutableList<String> = mutableListOf<String>()

    for(i in 0 until n)
        l.addLast(reader.readLine().split(":").joinToString(""))

    var counter = 1
    var current = l[0]
    for(i in 1 until l.size) {
        if(current >= l[i]) counter++
        current = l[i]
    }
    writer.write("${maxOf(0,l.size - counter)}")
    reader.close()
    writer.close()
}