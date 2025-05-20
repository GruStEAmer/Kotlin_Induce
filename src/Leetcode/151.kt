package Leetcode

fun main() {
    println(reverseWords("  a good   example  "))
}

fun reverseWords(s: String): String {
    var sz = s.length - 1
    var ans = ""
    var word = ""
    while(sz >= 0){
        if(s[sz] == ' '){
            if(word != "") {
                for (i in word.length - 1 downTo 0)
                    ans += word[i]
                ans += " "
                word = ""
            }
        }
        else{
            word += s[sz]
        }

        sz--
    }
    if(word != ""){
        for(i in word.length-1 downTo 0)
            ans += word[i]
    }
    return if(ans.last() == ' ') ans.dropLast(1) else ans
}