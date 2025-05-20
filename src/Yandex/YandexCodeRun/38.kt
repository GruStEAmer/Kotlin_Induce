package Yandex.YandexCodeRun

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val matrix = Array(n) {
        CharArray(n) { '*' }
    }
    for(i in 0 until n) {
        val r = reader.readLine().trim()
        for(j in 0 until n){
            matrix[i][j] = r[j]
        }
    }
    val q: Queue<Pair<Int,Int>> = LinkedList()
    val r = reader.readLine().split(' ').map{it.toInt() - 1}
    q.offer(Pair(r[0], r[1]))

    var s = 1
    matrix[r[0]][r[1]] = '*'
    while(q.isNotEmpty()){
        val (x,y) = q.poll()

        if(matrix[x+1][y] == '.'){
            s++
            matrix[x+1][y] = '*'
            q.offer(Pair(x+1, y))
        }
        if(matrix[x-1][y] == '.'){
            s++
            matrix[x-1][y] = '*'
            q.offer(Pair(x-1, y))
        }
        if(matrix[x][y+1] == '.'){
            s++
            matrix[x][y+1] = '*'
            q.offer(Pair(x, y+1))
        }
        if(matrix[x][y-1] == '.'){
            s++
            matrix[x][y-1] = '*'
            q.offer(Pair(x, y-1))
        }
    }
    println("$s")

    reader.close()
    writer.close()
}