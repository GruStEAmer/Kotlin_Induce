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
    var i = 0
    while (i < s.length) {
        if(s.count {it == s[0] || it == '!'} == s.length){
            ans = ((s.length-1) * (s.length) /2).toLong()
            break
        }
        if (s[i] in 'a'..'z') {
            val ch = s[i]
            var j = i
            while (j < s.length && (s[j] == ch || s[j] == '!')) {
                j++
            }
            val len = j - i
            if (len >= 2) {
                ans += len.toLong() * (len - 1) / 2
            }
            i = j
        } else {
            i++
        }
    }
    writer.write("$ans")
    reader.close()
    writer.close()
}