package Yandex.TrainingAlgorithm.Part7.Lesson4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = reader.readLine().split(' ').map { it.toInt() }
    val parent = IntArray(n) { it }
    val rank = IntArray(n) { 1 }
    var components =  n
    var result = 0

    for(i in 1..m) {
        val (x,y) = reader.readLine().split(' ').map { it.toInt() - 1 }
        val rootX = find(parent ,x)
        val rootY = find(parent, y)

        if(rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX
            } else {
                parent[rootY] = rootX
                rank[rootX]++
            }
            components--
            result = i
            if(components == 1) break
        }
    }
    writer.write("$result")
    reader.close()
    writer.close()
}
fun find(parent: IntArray,x: Int): Int {
    if (parent[x] != x) {
        parent[x] = find(parent ,parent[x])
    }
    return parent[x]
}