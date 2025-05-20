package Leetcode


fun main() {
    println("${myPow(34.00515, -3)}")
}

fun myPow(x: Double, n: Int): Double {
    var k = 1.0
    if(n == 0) return k
    fun recursive(a: Double, b: Int): Double {
        if(b == 1 || b == -1) return a

        return if(b % 2 == 0)
            recursive(a * a, b / 2)
        else {
            k *= a
            recursive(a, b - 1)
        }
    }
    if(n > 100 || n < -100)
        return if(n < 0) recursive(1/x, n) * k else recursive(x, n) * k
    else
        return if(n < 0) 1/recursive(x, n) * k else recursive(x, n) * k
}