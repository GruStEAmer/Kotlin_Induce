package Leetcode

import kotlin.math.min

fun main() {
    println("${minSubArrayLen(23, intArrayOf(2,3,1,2,12,7))}")
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var left = 0
    var right = 0
    var sum = 0
    var ans = Int.MAX_VALUE
    val sz = nums.size

    while(right < sz) {
        if(sum < target){
            sum += nums[right]
            right++
        }
        else if(sum > target) {
            sum -= nums[left]
            left++
        }
        if(sum == target) {
            ans = min(ans,right - left)
            sum -= nums[left]
            left++
        }
    }
    while(left < sz){
        if(sum == target){
            ans = min(ans,right - left)
        }
        sum -= nums[left]
        left++
    }
    return if(ans == Int.MAX_VALUE) 0 else ans
}