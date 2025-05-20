package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (k,t) = reader.readLine().split(' ').map{
        it.toInt()
    }
    val l : MutableList<Int> = MutableList<Int>( t + 1 ) { 0 }
    for(i in 0 until k){
        val (start, end, period) = reader.readLine().split(' ').map {
            it.toInt()
        }
        val mx = min(t , end + period)
        for(j in end .. mx){
            l[j] = 1
        }
    }
    val ans:Int = l.sum()
    if(ans == t) writer.write("Yes")
    else writer.write("No")

    reader.close()
    writer.close()
}