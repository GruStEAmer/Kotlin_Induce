package Yandex.TrainingAlgorithm.Part7.Lesson3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun sum(t: LongArray, id: Int): Long {
    var res = 0L
    var i = id
    while (i > 0) {
        res += t[i]
        i = i.and(i - 1)
    }
    return res
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, s) = reader.readLine().split(' ').map { it.toInt() }

    val arr = LongArray(n + 1) { 0L }
    val t = LongArray(n + 1) { 0L }

    repeat(s) {
        val r = reader.readLine().trim().split(' ')
        if (r[0] == "A") {
            val a = r[1].toInt()
            val b = r[2].toLong()
            val delta = b - arr[a]
            arr[a] = b

            var i = a
            while (i <= n) {
                t[i] += delta
                i += i.and(-i)
            }
        } else if (r[0] == "Q") {
            val left = r[1].toInt()
            val right = r[2].toInt()
            val res = sum(t, right) - sum(t, left - 1)
            writer.write("$res\n")
        }
    }

    reader.close()
    writer.close()
}
