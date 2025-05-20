package Yandex.TrainingAlgorithm.Part7.Lesson3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n,s) = reader.readLine().split(' ').map { it.toInt() }
    val array = LongArray(n) { 0L }

    val t = LongArray(n) { 0L }
    for(i in 0..< n){
        var k = i.and(i+1)
        var sum = 0L
        while(k <= i){
            sum += array[k]
            k++
        }
        t[i] = sum
    }
    repeat(s) {
        val r = reader.readLine().trim().split(' ')
        if(r[0] == "A"){
            var a = r[1].toInt() - 1
            val b = r[2].toLong()
            array[a] = b
            for(i in 0..< n){
                var k = i.and(i+1)
                var sum = 0L
                while(k <= i){
                    sum += array[k]
                    k++
                }
                t[i] = sum
            }
        }
        else if(r[0] == "Q"){
            var a = r[1].toInt() - 2
            var b = r[2].toInt() - 1

            var sum1 = 0L
            while(a > 0){
                sum1 += t[a]
                a = a.and(a + 1) - 1
            }
            var sum2 = 0L
            while(b >= 0){
                sum2 += t[b]
                b = b.and(b + 1) - 1
            }
            println(sum2 - sum1)
        }
    }
    reader.close()
    writer.close()
}