package Yandex.TrainingAlgorithm.Part7.Lesson3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val x = n.toString(2)

    var r = 0
    var c = Pair(0, 0)
    var counter = 0
    if(x.count { it == '1' } == x.length){
        println(n)
        reader.close()
        writer.close()
        return
    }
    while(r < x.length){
        if(x[r] == '1') {
            counter++
        }
        else {
            counter = 0
        }

        if(c.second < counter)
            c = Pair(r - counter + 1, counter)

        r++
    }
    counter = 0
    r = 0
    while(x[r] == '1'){
        counter++
        r++
    }
    r = x.length - 1
    while(x[r] == '1'){
        counter++
        r--
    }
    var ans = ""
    r++
    if(counter > c.second){
        ans = x.substring(r, x.length) + x.substring(0, r)
        println(ans.toInt(2))
    }
    else {
        ans = x.substring(c.first, x.length) + x.substring(0, c.first)
        println(ans.toInt(2))
    }

    reader.close()
    writer.close()
}