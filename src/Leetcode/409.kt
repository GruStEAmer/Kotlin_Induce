package Leetcode

fun main() {
    println("${longestPalindrome("abccccdd")}")
}

fun longestPalindrome(s: String): Int {
    val hm: HashMap<Char, Int> = hashMapOf()
    for(i in s) {
        if(hm.containsKey(i)) {
            hm.set(i , hm.get(i)!! + 1)
        }
        else {
            hm[i] = 1
        }
    }
    var sum = 0
    var flag = true
    for(i in hm) {
        if(flag)
            if (i.value % 2 == 1) {
                sum++
                flag = false
            }
        sum += i.value - i.value % 2
    }
    return sum
}