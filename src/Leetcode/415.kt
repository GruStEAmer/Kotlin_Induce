package Leetcode

fun addStrings(num1: String, num2: String): String {
    var answer = ""

    var sz1 = num1.length
    val sz2 = num2.length
    var s1 = num1
    var s2 = num2
    if(sz1 > sz2){
        repeat(sz1 - sz2){
            s2 = "0$s2"
        }
    }
    else {
        repeat(sz2 - sz1){
            s1 = "0$s1"
        }
        sz1 = sz2
    }
    var flag = 0
    for(i in sz1-1 downTo 0){
        val sum = convert(s1[i]) + convert(s2[i])
        answer = ('0' + ((sum+flag) %  10)) + answer
        flag = (sum+flag) / 10
    }
    if(flag != 0)
        answer = ('0' + flag) + answer
    return answer
}

fun convert(c: Char):Int {
    return c - '0'
}