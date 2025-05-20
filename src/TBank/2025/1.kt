package TBank.`2025`

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))
    var flag = false
    val s = reader.readLine().trim()
    var counter = 0
    for(i in 0 until s.length){
        var s1 = ""
        for(j in 0 until s.length){
            if(i != j) s1 += s[j]
        }
        if(s1 == s1.reversed())
            flag = true
    }
    if(flag) writer.write("YES")
    else writer.write("NO")
    reader.close()
    writer.close()
}