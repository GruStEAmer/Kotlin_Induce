package Leetcode

fun productExceptSelf(nums: IntArray): IntArray {
    val answer = IntArray(nums.size) { 0 }
    var flagZero = 0
    var product = 1
    nums.forEach {
        if(it == 0) flagZero++
        else product *= it
    }

    if(flagZero == nums.size)
        return answer
    else if(flagZero == 1){
        for(i in 0..< answer.size){
            if(nums[i] == 0)
                answer[i] = product
        }
    }
    else if(flagZero > 1)
        return answer
    else{
        for(i in 0..< answer.size)
            answer[i] = product / nums[i]
    }
    return answer
}