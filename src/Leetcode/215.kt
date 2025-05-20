package Leetcode

import java.util.PriorityQueue

fun findKthLargest(nums: IntArray, k: Int): Int {
    val pq = PriorityQueue<Int>()

    for(num in nums){
        if(pq.size < k)
            pq.offer(num)
        else if(num > pq.peek()){
            pq.poll()
            pq.offer(num)
        }
    }
    return pq.peek()
}