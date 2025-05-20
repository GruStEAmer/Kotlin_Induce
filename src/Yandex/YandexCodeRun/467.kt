package Yandex.YandexCodeRun

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val a = reader.readLine().toInt() - 27

    for(i in a..a+54){
        var k = i
        if(i < 100000) k = 100000
        val ans = k.toString().map{
            it.toString().toInt()
        }
        if(ans[0] + ans[1] + ans[2] == ans[3] + ans[4] + ans[5]){
            writer.write("${k}")
            break
        }
    }
    reader.close()
    writer.close()
}