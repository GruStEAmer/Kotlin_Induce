package Leetcode

import java.util.PriorityQueue
import kotlin.collections.HashMap


fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = HashMap<Int, Int>()
    for(i in nums){
        map[i] = map.getOrDefault(i , 0) + 1
    }
    val pq  = PriorityQueue<Pair<Int, Int>>( compareByDescending { it.second })
    map.forEach { it->
        pq.offer(Pair(it.key , it.value))
    }

    val list = IntArray(k) { 0 }
    for(i in 0..< k)
        list[i] = pq.poll().first
    return list
}