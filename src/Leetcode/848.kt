package Leetcode

fun main() {
    val a = shiftingLetters("ruu" , intArrayOf(26,9,17))
    for(i in a) print("$i ")
}

fun shiftingLetters(s: String, shifts: IntArray): String {
    val prefixSum = IntArray(shifts.size) { 0 }
    val sz = shifts.size - 1
    prefixSum[sz] = shifts[sz] % 26
    for(i in sz downTo 1){
        prefixSum[i - 1] = (shifts[i - 1] + prefixSum[i]) % 26
    }
    var ans = ""
    for(i in 0..sz){
        ans += ('a' + ((s[i] - 'a') + prefixSum[i]) % 26).toChar()
    }
    return ans
}