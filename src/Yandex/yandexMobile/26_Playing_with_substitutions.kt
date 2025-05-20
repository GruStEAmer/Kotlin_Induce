package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val t:Int = reader.readLine().toInt()
    val s:MutableList<String> = mutableListOf()

    for(i in 0 until t) {
        var x = reader.readLine()
        var y = reader.readLine()

        for(i in 0 until x.length){
            if(x[i] == ' ' && y[i] == ' ')
                continue
            else if((x[i] == ' ' || y[i] == ' ') && (x[i] != y[i])){
                s.addLast("NO")
                break
            }
            else{
                x = x.replace(x[i], ' ')
                y = y.replace(y[i] , ' ')
                println("$x, $y")
            }
        }
        if(x == y) s.addLast("YES")
    }
    for (i in s) writer.write(i)
}