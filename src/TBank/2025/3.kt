package TBank.`2025`

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().trim().toInt()

    val array = reader.readLine().trim().split(' ').map { it.toInt() }.sortedByDescending { it }
    val hs = hashSetOf<Int>()
    for(i in 0 until n){
        var j = array[i]
        if(!hs.contains(j))
            hs.add(j)
        else
            while(hs.contains(j) && j > 0)
                j /= 2
            hs.add(j)
    }
    writer.write("${hs.size}")
    println(hs)

    reader.close()
    writer.close()
}

//fun main() {
//    val reader = BufferedReader(InputStreamReader(System.`in`))
//    val writer = BufferedWriter(OutputStreamWriter(System.`out`))
//
//    reader.close()
//    writer.close()
//}