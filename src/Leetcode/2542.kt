package Leetcode

import java.util.PriorityQueue
import kotlin.math.max

fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
    val pq = PriorityQueue<Pair<Int,Int>>( compareBy { it.second })
    var sum = 0
    var answer = 0L
    var j = 0
    while(j < k){
        sum += nums1[j]
        pq.offer( Pair(nums1[j] , nums2[j]))
        j++
    }
    answer = max( answer, (sum * pq.peek().second).toLong())
    while(j < nums1.size){
        sum -= pq.poll().first
        pq.offer( Pair(nums1[j] , nums2[j]))
        sum += nums1[j]

        answer = max( answer, (sum * pq.peek().second).toLong())
        j++
    }
    return answer
}