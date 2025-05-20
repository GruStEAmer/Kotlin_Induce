package Leetcode

import java.util.PriorityQueue

fun largestInteger(num: Int): String {
    var s = num.toString()
    val odd = PriorityQueue<Char>( compareByDescending { it })
    val notOdd = PriorityQueue<Char>(compareByDescending { it })

    for(i in s){
        if(i.code % 2 == 0)
            notOdd.offer(i)
        else odd.offer(i)
    }
    var ans = ""
    for(i in 0..< s.length) {
        if(s[i].code % 2 == 0)
            ans += notOdd.poll()
        else ans += odd.poll()
    }
    return ans
}
fun main(){
    println("${largestInteger(1234)}")
}