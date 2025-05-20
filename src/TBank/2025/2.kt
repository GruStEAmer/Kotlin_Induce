package TBank.`2025`

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val array = Array<Pair<Int, Int>>(n) { Pair(0,0) }
    for(i in 0 until n){
        val (x, y) = reader.readLine().split(' ').map { it.toInt()}
        array[i] = Pair(x,y)
    }
    val m = reader.readLine().toInt()
    repeat(m) {
        val (t, d) = reader.readLine().split(' ').map{ it.toInt() }
        if(d <= array[t-1].first)
            writer.write("${array[t-1].first}\n2")
        else {
            var k = (d - array[t-1].first) / array[t-1].second
            k = array[t-1].first + k * array[t-1].second
            if(d == k)
                writer.write("$k\n")
            else
                writer.write("${k + array[t-1].second}\n")
        }
    }
    reader.close()
    writer.close()
}

//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//
//fun main() {
//    val reader = BufferedReader(InputStreamReader(System.`in`))
//    val writer = BufferedWriter(OutputStreamWriter(System.`out`))
//
//    reader.close()
//    writer.close()
//}