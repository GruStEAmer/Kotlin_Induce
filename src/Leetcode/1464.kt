package Leetcode
import java.util.PriorityQueue

fun maxProduct(nums: IntArray): Int {
    val pq = PriorityQueue<Int>( compareByDescending { it })
    for(i in nums)
        pq.offer(i)
    return (pq.poll()-1) * (pq.poll()-1)
}