package Leetcode

import kotlin.math.abs

fun sortedSquares(nums: IntArray): IntArray {
    val answer = IntArray(nums.size) { 0 }
    var l = 0
    var r = answer.size - 1

    while(l <= r){
        if(abs(nums[l]) > abs(nums[r])){
            answer[r - l] = nums[l] * nums[l]
            l++
        }
        else{
            answer[r - l] = nums[r] * nums[r]
            r--
        }
    }
    return answer
}