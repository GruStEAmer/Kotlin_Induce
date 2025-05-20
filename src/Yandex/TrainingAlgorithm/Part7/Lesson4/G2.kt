package Yandex.TrainingAlgorithm.Part7.Lesson4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }

    val dsu = DSU(n)
    var result = 0

    for (i in 1..m) {
        val (x, y) = reader.readLine().split(" ").map { it.toInt() - 1 }
        if (dsu.union(x, y)) {
            result = i
            if (dsu.components == 1) break
        }
    }

    println(result)
}

class DSU(size: Int) {
    private val parent = IntArray(size) { it }
    private val rank = IntArray(size) { 1 }
    var components = size

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX == rootY) return false

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX
        } else {
            parent[rootY] = rootX
            rank[rootX]++
        }

        components--
        return true
    }
}