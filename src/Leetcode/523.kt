package Leetcode

fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    val pref = IntArray(nums.size){ 0 }
    pref[0] = nums[0] % k

    var counterZero = 0
    for(i in 1 until  nums.size){
        pref[i] = (pref[i - 1] + nums[i]) % k
        if(nums[i] == 0 && nums[i-1] == 0)
            counterZero++
    }
    if(counterZero > 0)
        return true

    val hm = hashMapOf<Int,Int>()
    hm[pref[0]] = hm.getOrDefault(pref[0], 0) + 1
    for(i in 1 until pref.size) {
        if (pref[i] != pref[i - 1])
            hm[pref[i]] = hm.getOrDefault(pref[i], 0) + 1
        if (hm[pref[i]]!! > 1) {
            return true
        }
    }
    return false
}