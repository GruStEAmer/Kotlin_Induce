package Leetcode

fun main() {
    val ans = wordPattern("aa", "cat cat cat cat")
    println(ans)
}
fun wordPattern(pattern: String, s: String):Boolean {
    val str = s.split(" ")
    val hm = HashMap<Char, String>()
    if(str.size != pattern.length) return false
    for(i in 0 until str.size){
        if(hm.containsKey(pattern[i])){
            if(hm[pattern[i]] != str[i])
                return false
        }
        else {
            if(hm.containsValue(str[i])) return false
            hm[pattern[i]] = str[i]
        }
    }
    return true
}