package Leetcode

import kotlin.math.max

fun main() {
    val a = arrayOf(
        intArrayOf(1,4),
        intArrayOf(2,3)
    )
    val ans = merge(a)
    for(i in ans) {
        for(j in i) println("$j ")
    }
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortBy {
        it[0]
    }
    val ans = mutableListOf<IntArray>().apply{ add(intervals[0])}
    for(i in 1 ..< intervals.size){
        if(intervals[i-1][1] >= intervals[i][0]) {
            if(!ans.isEmpty()){
                if(ans.last().contentEquals(intervals[i-1])) ans.removeLast()
            }
            ans.add(intArrayOf(intervals[i - 1][0],max(intervals[i-1][1],intervals[i][1])))
            intervals[i] = ans.last()
        }
        else ans.add(intArrayOf(intervals[i][0] , intervals[i][1]))
    }
    return ans.toTypedArray()
}