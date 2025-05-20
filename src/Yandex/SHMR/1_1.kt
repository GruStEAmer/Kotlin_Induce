package Yandex.SHMR

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine().toInt()
    val str = reader.readLine()
    val a = reader.readLine().split(' ').map{ it.toLong()}

    if(n > 1){
        var mx = Pair(str[0], a[0])
        for(i in 1..<n){
            if (mx.second <= a[i] - a[i-1]) mx = Pair(str[i], a[i]-a[i-1])
        }
        writer.write("${mx.first}")
    }
    else writer.write(str)

    reader.close()
    writer.close()
}