package Leetcode

import kotlin.math.max

fun longestSubarray(nums: IntArray): Int {
    var l = 0
    var r = 0
    var zeroFlag = false
    var answer = 0
    while(r < nums.size){
        if(nums[r] == 0 && zeroFlag){
            while(nums[l] != 0 && l < r - 1)
                l++
            l++
        }

        if(nums[r] == 0) zeroFlag = true
        answer = max(answer, (r - l))
        r++
    }
    return answer
}