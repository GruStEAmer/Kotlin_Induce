package Solutions

class Valid_Palindrome {
    fun isPalindrome(s: String): Boolean{
        var left = 0
        var right = s.length - 1

        while(left < right){
            if((s[left].uppercaseChar().code in 65..90 || s[left] in "0123456789") && (s[right].uppercaseChar().code in 65..90 || s[right] in "0123456789")){
                if(s[left].uppercaseChar() != s[right].uppercaseChar()){
                    return false
                }
                left++
                right--
            }
            else if((s[left].uppercaseChar().code !in 65..90)) left++
            else if((s[right].uppercaseChar().code !in 65..90)) right--
        }
        return true
    }
}
fun main(){
    println(Valid_Palindrome().isPalindrome("0P"))
}