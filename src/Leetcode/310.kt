package Leetcode

import kotlin.math.max
import kotlin.math.min

fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    val e = List<MutableList<Int>>(n) { mutableListOf() }
    for(i in edges){
        e[i[0]].add(i[1])
        e[i[1]].add(i[0])
    }
    val answer = mutableListOf<Pair<Int,Int>>()
    var minimum = Int.MAX_VALUE
    for(i in 0 until n){
        var c = 0
        val visited = Array(n) { false }
        fun dfs(node: Int, count: Int){
            visited[node] = true
            for(j in e[node]){
                if(!visited[j]){
                    c = max(c, count + 1)
                    if(c <= minimum)
                        dfs(j, count  + 1)
                    else break
                }
            }
        }
        dfs(i, 0)
        answer.add(Pair(i, c))
        minimum = min(minimum, c)
    }
    return answer.filter { it.second == minimum}.map { it.first }
}