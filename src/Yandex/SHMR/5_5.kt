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
    var countW = 0
    var l = 0
    var r = 0
    while(r < s.length){
        if(s[r] == '!'){
            countW++
            r++
        }
        else {
            ans += ((r-l-1)*(r - l))/2 + countW
            if(r + 1 != s.length)countW = 0
            l = r
            r++
        }
    }
    ans += ((r-l-1)*(r - l))/2 + countW
    
    writer.write("$ans")

    reader.close()
    writer.close()
}