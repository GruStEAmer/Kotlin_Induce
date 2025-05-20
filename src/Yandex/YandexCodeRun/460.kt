package Yandex.YandexCodeRun

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val pr = reader.readLine().split(" ")
    val n = pr[0].toInt()
    val m = pr[1].toInt()

    var sum = 0
    val l:List<Int> = reader.readLine().split(" ").map{
        sum += it.toInt()
        it.toInt()
    }

    var ans = 0
    for (i in l) {
        if(i != 0){
            sum-=i
            ans += sum + i * i

        }
    }

    writer.write("$ans")
    reader.close()
    writer.close()
}