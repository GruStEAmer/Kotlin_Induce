package Leetcode

import java.util.PriorityQueue
import kotlin.math.max


fun deleteGreatestValue(grid: Array<IntArray>): Int {
    var  ans = 0
    val sz = grid[0].size
    val matrix = mutableListOf<PriorityQueue<Int>>()
    for(i in grid){
        val pq = PriorityQueue<Int>( compareByDescending { it })
        for(j in i)
            pq.offer(j)
        matrix.add(pq)
    }
    repeat(sz){
        var mx = 0
        for (i in matrix) {
            mx = max(i.poll(), mx)
        }
        ans+=mx
    }
    return ans
}