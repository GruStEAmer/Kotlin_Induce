package Leetcode

import kotlin.math.max
import kotlin.math.min

fun maxArea(height: IntArray): Int {
    var s = 0
    var l = 0
    var r = height.size - 1
    while(l < r){
        s = max(s, min(height[l] , height[r]) * (r - l))
        if(height[l] < height[r])
            l++
        else r--
    }
    return s
}