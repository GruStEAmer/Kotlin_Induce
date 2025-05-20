package Leetcode

import java.util.*

fun firstUniqChar(s: String): Int {
    val hs = hashMapOf<Char, Int>()
    val q: Queue<Int> = LinkedList<Int>()

    for(i in 0..< s.length){
        if(!hs.containsKey(s[i])){ q.offer(i) }
        hs[s[i]] = hs.getOrDefault(s[i], 0) + 1
    }
    var ans = -1
    while(q.isNotEmpty()){
        val x = q.poll()
        if(hs[s[x]] == 1){
            ans = x
            break
        }
    }
    return ans
}