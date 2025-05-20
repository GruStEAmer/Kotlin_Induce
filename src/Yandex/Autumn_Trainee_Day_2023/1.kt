package Yandex.Autumn_Trainee_Day_2023

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val s:String = reader.readLine()

    var sum:Int = 0
    var str = ""
    for(i in s){
        if(i != '+' && i != '-'){
            str += i
        }
        else if(i == '+'){
            if(str != "") sum += str.toInt()
            str = ""
        }
        else if(i == '-'){
            if(str != "") sum += str.toInt()
            str = "-"
        }
    }
    if(str != "") sum += str.toInt()
    writer.write("$sum")

    reader.close()
    writer.close()
}