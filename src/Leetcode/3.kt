package Leetcode

fun main() {
    println("${lengthOfLongestSubstring("abbbbb")}")
}

fun lengthOfLongestSubstring(s: String): Int {
    if(s == "") return 0
    val hs = hashSetOf<Char>()
    var counter = 0
    var left = 0
    var right = 0

    while(right < s.length){
        if(!hs.contains(s[right])){
            hs.add(s[right])
            counter = if(right - left + 1 > counter) right-left+1 else counter
        }
        else {
            while(s[right] != s[left]) {
                hs.remove(s[left])
                left++
            }
            left++
        }
        right++
    }
    return counter
}
