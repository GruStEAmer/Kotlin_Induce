package Yandex.YandexCodeRun

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val a = reader.readLine().split(" ")
    val n:Int = a[0].toInt()
    val k:Int = a[1].toInt()

    val names = mutableMapOf<String, Int>()
    for(i in 0..<n){
        val rd:String = reader.readLine()
        val txt:List<String> = reader.readLine().split(" ")
        if(names.containsKey(rd)){
            names[rd] = names[rd]!! + txt.count{
                it == "goose"
            }
        }
        else names[rd] = txt.count{
            it == "goose"
        }
    }
    val ans:MutableList<String> = mutableListOf()
    for(i in names){
        if(i.value >= k) ans.add(i.key)
    }
    writer.write("${ans.size}\n")
    for(i in ans) writer.write("$i\n")
    reader.close()
    writer.close()
}