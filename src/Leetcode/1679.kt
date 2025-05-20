package Leetcode


fun maxOperations(nums: IntArray, k: Int): Int {
    val hs = hashMapOf<Int,Int>()
    var ans = 0
    for(i in nums){
        if(hs.containsKey(k-i)){
            if(hs[k-i] != 0){
                hs[k - i] = hs[k - i]!! - 1
                ans++
            }
            else if(hs.containsKey(i)){
                hs[i] = hs[i]!! + 1
            }
            else hs[i] = 1
        }
        else if(hs.containsKey(i)){
            hs[i] = hs[i]!! + 1
        }
        else hs[i] = 1
    }
    return ans
}