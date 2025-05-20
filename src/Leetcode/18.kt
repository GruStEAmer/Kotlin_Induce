package Leetcode

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val numsA = nums.sorted()
    val ans = mutableSetOf<List<Int>>()
    var yOut = numsA.size - 1
    while(yOut > 0) {
        var xOut = 0
        while (xOut < yOut) {
            var xIn = xOut + 1
            var yIn = yOut - 1

            while (xIn < yIn) {
                val sum = numsA[xOut].toLong() + numsA[yOut] + numsA[xIn] + numsA[yIn]
                if (sum > target)
                    yIn--
                else if (sum < target)
                    xIn++
                else {
                    ans.add(listOf(numsA[xOut], numsA[xIn], numsA[yIn], numsA[yOut]))
                    xIn++
                }
            }
            xOut++
        }
        yOut--
    }
    return ans.toList()
}