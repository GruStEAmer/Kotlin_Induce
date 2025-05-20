package TBank.`2025`
//Неправильно!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val array = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    var count = 0

    for (l in 0 until n) {
        val seen = mutableSetOf<Int>()
        for (r in l until n) {
            seen.add(array[r])
            if (seen.size >= 3) {
                count += n - r
                break
            }
        }
    }
    writer.write("$count")
    reader.close()
    writer.close()
}