package Yandex.yandexMobile_1_to_34_2025year

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val a = reader.readLine().split(' ').map{ it.toInt() }
    val b = reader.readLine().split(' ').map{ it.toInt() }

    var ans = Pair(Int.MAX_VALUE, Long.MAX_VALUE)
    for(i in 0 until n){
        var current = 0L
        var flag = false
        var j = i
        while(true){
            if(j >= n)
                j = 0
            if(flag && j == i)
                break
            else flag = true
            if(a[j] < b[j]) {
                if (b[j] - a[j] <= 100)
                    current += (b[j] - a[j]) / 2
                else current += 30
            }
            j++
        }
        if(current < ans.second)
            ans = Pair(i+1, current)
    }
    writer.write("${ans.first} ${ans.second}")

    reader.close()
    writer.close()
}