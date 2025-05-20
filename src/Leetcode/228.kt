package Leetcode

fun summaryRanges(nums: IntArray): List<String> {
    if(nums.size == 0) return listOf<String>()
    val answer = mutableListOf<String>()
    var l = 0
    var r = 0
    var counter = 0
    while(r < nums.size){
        if(nums[l] != nums[r] - counter){
            if(nums[l] != nums[r-1])
                answer.add("${nums[l]}->${nums[r-1]}")
            else
                answer.add("${nums[l]}")
            l = r
            counter = 0
        }
        counter++
        r++
    }
    if(nums[l] != nums[r-1])
        answer.add("${nums[l]}->${nums[r-1]}")
    else
        answer.add("${nums[l]}")
    return answer
}