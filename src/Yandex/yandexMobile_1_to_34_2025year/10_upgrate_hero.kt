package Yandex.yandexMobile_1_to_34_2025year

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val r = reader.readLine().split(' ').map { it.toInt() }.sortedBy { abs(it) }
    var p = 1L
    var flag = false
    var counter = 0
    for(i in r) {
        if(i < 0) {
            counter++
            p *= -1
        }
        if(i == 0) flag = true
    }
    if(counter == r.size  && counter % 2 == 0)
        println("${r[r.size-1]}")
    else if(p < 0){
        for(i in r)
            if(i < 0){
                println("$i")
                break
            }
    }
    else if(flag)
        println("0")
    else {
        for(i in r)
            if(i > 0){
                println("$i")
                break
            }
    }

    reader.close()
    writer.close()
}