package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val l: List<Int> = mutableListOf<Int>().apply {
        addLast(0)
        for(i in 1 .. 100000 step 5){
            addLast(1)
            addLast(0)
            addLast(1)
            addLast(1)
            addLast(0)
        }
    }
    val n = reader.readLine().toInt()
    val ans: MutableList<Int> = mutableListOf()

    for(i in 0 until n){
        val x = reader.readLine().toInt()
        ans.addLast(l[x])
    }
    for(i in ans) writer.write("$i\n")

    reader.close()
    writer.close()
}