package Yandex.TrainingAlgorithm.Part7.Lesson3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine()
    if(n == "1"){
        val x = reader.readLine()
        val ans = Array<Char>(3 * x.length) { ' '}
        var j = 0
        for(i in x){
            ans[j++] = i
            ans[j++] = i
            ans[j++] = i
        }
        for(i in ans) print("$i")
    }
    else if(n == "2"){
        val x = reader.readLine()
        var ans = ""
        for(i in 0..< x.length-2 step 3){
            if(x[i] == x[i+1] || x[i] == x[i+2])
                ans+=x[i]
            else if(x[i+1] == x[i+2])
                ans+=x[i+1]
        }
        println(ans)
    }
    reader.close()
    writer.close()
}