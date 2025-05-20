//РЕШЕНО
package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter



fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val s = reader.readLines()
    val size = s.size
    val n: MutableList<String> = MutableList(size + 1) {""}

    for(i in s) {
        var number = ""
        var start = true
        var startInt: Int = 0
        var endInt: Int = 0
        for (j in 0 until i.length) {
            if (i[j] in "0123456789") {
                number += i[j]
            }
        }
        n.set(number.toInt(), i.replace(number, ""))
    }
    for( i in 1 until n.size) writer.write("${n[i]}\n")
    reader.close()
    writer.close()
}