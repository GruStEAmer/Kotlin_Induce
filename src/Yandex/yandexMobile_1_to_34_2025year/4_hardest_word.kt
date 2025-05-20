package Yandex.yandexMobile_1_to_34_2025year

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.Pair

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val size = reader.readLine().toInt()
    val s = reader.readLine()
    val timer:List<Int> = reader.readLine().split(" ").map{
        it.toInt()
    }

    var answer:Pair<Int, Int> = Pair(0, timer.elementAt(0))
    for(i in 1..<timer.size){
        val delta = timer.elementAt(i) - timer.elementAt(i-1)
        if(answer.second <= delta){
            answer = Pair(i, delta)
        }
    }
    writer.write("${s.get(answer.first)}")

    reader.close()
    writer.close()
}