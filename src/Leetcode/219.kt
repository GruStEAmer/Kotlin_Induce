package Leetcode

fun main() {

}
fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val hm:HashMap<Int , Int> = hashMapOf()
    val sz = nums.size
    for(i in 0 ..< sz){
        if(hm.containsKey(nums[i])){
            if(i - hm[nums[i]]!! <= k) return true
        }
        hm[nums[i]] = i
    }
    return false
}