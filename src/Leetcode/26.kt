package Leetcode

fun main() {
    val a:IntArray = intArrayOf(1,1,2)
    val b = removeDuplicates(a)
    println("$b")
}

fun removeDuplicates(nums: IntArray): Int {
    if(nums.size == 1) return 1
    var left = 0
    var right = 0
    var counter = 1
    while( right < nums.size) {
        if(nums[left] != nums[right]){
            left++
            nums[left] = nums[right]
            counter++
        }
        right++
    }
    return counter
}