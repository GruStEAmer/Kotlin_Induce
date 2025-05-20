//РЕШЕНО
package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (n,m) = reader.readLine().split(" ").map{
        it.toInt()
    }
    val hm = hashMapOf<String, Boolean>()
    val name = reader.readLine().split(" ").forEach {
        hm[it] = false
    }
    val start = reader.readLine()

    val v:List<Pair<String, String>> = mutableListOf<Pair<String, String>>().apply {
        for(i in 0 until m){
            val (x, y) = reader.readLine().split(" ")
            addLast(Pair(x, y))
        }
    }

    hm[start] = true
    for( i in v){
        if(hm[i.first] == true)
            hm[i.second] = true
    }
    var ans = 0
    hm.forEach {
        ans += if(!it.value) 1 else 0
    }
    writer.write("$ans")
    reader.close()
    writer.close()
}