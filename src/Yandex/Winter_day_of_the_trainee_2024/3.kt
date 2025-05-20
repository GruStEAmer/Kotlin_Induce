package Yandex.Winter_day_of_the_trainee_2024

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (n,t,s) = reader.readLine().split(' ').map{ it.toInt()}
    val v: List<Long> = reader.readLine().split(' ').map{ it.toLong()}.sortedWith { a , b -> (b-a).toInt()}

    var counter = 0L
    for(j in 0..< n){
        for (i in n-1 downTo j+1) {
            val vv = (v[j] - v[i]) * t
            if(vv <= s) break
            val d =  (vv / s) - if(vv % s == 0L) 1 else 0;
            counter += d;
        }
    }
    writer.write("$counter")

    reader.close()
    writer.close()
}