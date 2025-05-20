package Yandex.Winter_day_of_the_trainee_2024
//2. Заезд
//Зачтено
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (n,t,s) = reader.readLine().split(' ').map{ it.toInt()}
    val v: List<Long> = reader.readLine().split(' ').map{ it.toLong()}

    var counter = 0L
    for(i in 1..<n) {
        if(v[0] > v[i]) {
            val d = if(((v[0] - v[i]) * t % s) == 0L)1 else 0;
            counter += (v[0] - v[i]) * t / s - d;

        }
    }
    writer.write("$counter")

    reader.close()
    writer.close()
}