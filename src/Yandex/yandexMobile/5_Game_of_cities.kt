package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val a = reader
        .readLine()
        .trimEnd('.')
        .split(", ")

    val m:MutableMap<String,String> = mutableMapOf()
    var flag = true

    for (s in a) {
        val a: List<String> = s.split(" ")
        m.put(a[0], a[1])
        m.put(a[1], a[0])
    }

    val b = reader.readLine()
        .trimEnd('.')
        .split(", ")
    for(s in b){
        val a: List<String> = s.split(" ")
        if(!m.containsKey(a[0])){
            if(m[a[0]] != a[1]){
                writer.write("NO")
                flag = false
                break
            }
        }
    }
    if(flag) writer.write("YES")

    reader.close()
    writer.close()
}