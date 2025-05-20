package Leetcode

fun main() {
    var a = charArrayOf('a')
    println(compress(a))
    println(a)
}

fun compress(chars: CharArray): Int {
    var counter = 1
    var index = 0
    val sz = chars.size
    for(i in 1 until sz) {

        if(!chars[i].equals(chars[i-1])){
            chars[index++] = chars[i - 1]
            if(counter != 1){
                for (j in counter.toString()) {
                    chars[index++] = j
                }
            }
            counter = 1
        }
        else {
            counter++
        }
    }
    chars[index++] = chars.last()
    if(counter != 1){
        for (j in counter.toString()) {
            chars[index++] = j
        }
    }
    return index
}