package Yandex.YandexCodeRun

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val mp:MutableMap<String,Int> = mutableMapOf()
    val n = reader.readLine().toInt()

    repeat(n){
        val pr = reader.readLine().split(" ")
        if(pr[0] == "+"){
            if(mp.containsKey(pr[1])){
                mp[pr[1]] = mp[pr[1]]!! + pr[2].toInt()
            }
            else mp[pr[1]] = pr[2].toInt()
        }
        else if(pr[0] == "?"){
            var ans = Pair<String,Int>("",0)
            for(i in mp){
                if(pr[1] in i.key){
                    if(ans.second != 0){
                        println()
                    }
                    else ans = i.toPair()
                }
            }
        }
    }

    reader.close()
    writer.close()
}
