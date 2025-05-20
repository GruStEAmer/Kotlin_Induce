package Solutions

import java.util.Collections.max

fun main() {
    val t:Int = readln().toInt()
    val ans:MutableList<String> = mutableListOf<String>()

    for(i in 0..< t){
        val k = readln().split(" ").map{
            it.toInt()
        }

        if(max(k) * 2 - k[0] - k[1] - k[2] == 0){
            ans.add("YES")
        }
        else ans.add("NO")

    }
    for(i in 0..< t) println(ans[i])
}