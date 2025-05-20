package Yandex.SHMR

import java.io.*
import java.util.Queue
import java.util.LinkedList


fun main() {
    val reader = BufferedReader(FileReader("input.txt"))
    val writer = BufferedWriter(FileWriter("output.txt"))

    val n = reader.readLine().toInt()
    val array:Array<IntArray> = Array(n){
        IntArray(n) { Int.MAX_VALUE}
    }

    val q:Queue<Pair<Int,Int>> = LinkedList()

    repeat(reader.readLine().toInt()) {
        val (x,y) = reader.readLine().trim().split(Regex("\\s+")).map { it.toInt() }
        q.offer(Pair(x,y))
        array[x][y] = 0
    }
    var counter = 0
    val xSide = intArrayOf(-1,1,0,0)
    val ySide = intArrayOf(0,0,-1,1)
    while(!q.isEmpty()){
        val p = q.peek()
        q.poll()
        for(s in 0..3){
            val x = p.first + xSide[s]
            val y = p.second + ySide[s]
            if(x in 0 ..< n && y in 0..< n && array[x][y] == Int.MAX_VALUE){
                array[x][y] = array[p.first][p.second] + 1
                counter = maxOf(array[p.first][p.second] + 1, counter)
                q.offer(Pair(x,y))
            }
        }
    }
    writer.write("$counter")
    reader.close()
    writer.close()
}
