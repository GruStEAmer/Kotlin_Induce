package Yandex.SHMR

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val s = reader.readLine()
    var ans = 0L
    if(s.count {it == s[0] || it == '!'} == s.length){
        ans = ((s.length-1).toLong() * (s.length) /2)
        writer.write("$ans")

        reader.close()
        writer.close()
        return
    }
    for(i in 0..< s.length){
        var flagValue = s[i]
        var flag = (flagValue == '!')
        var r = i
        var count = 0L
        while(r < s.length-1){
            if(s[r+1] != '!' && flag){
                flagValue = s[r+1]
                flag = false
            }
            if(s[r+1] == '!' || s[r+1] == flagValue){
                count++
                r++
            }
            else break
        }
        ans+=count
    }
    writer.write("$ans")

    reader.close()
    writer.close()
}