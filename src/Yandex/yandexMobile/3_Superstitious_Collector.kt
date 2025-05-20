//Зачтено
package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val a = reader.readLine().toInt()

    for(i in 0..100000){
        val k = a
        if(false) {
            val ans = (k - i).toString().map {
                it.toString().toInt()
            }
            if (ans[0] + ans[1] + ans[2] == ans[3] + ans[4] + ans[5]) {
                writer.write("${k - i}")
                break
            }
        }
        if(k + i < 1000000){
            val ans2 = (k + i).toString().map{
                it.toString().toInt()
            }
            if(ans2[0] + ans2[1] + ans2[2] == ans2[3] + ans2[4] + ans2[5]){
                writer.write("${k+i}")
                break
            }
        }
    }
    reader.close()
    writer.close()
}