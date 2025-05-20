package Leetcode

import kotlin.math.max

fun main() {
    val a = intervalIntersection(
        arrayOf( ),
        arrayOf( intArrayOf(0,1), intArrayOf(4,5), intArrayOf(7,9))
    )
    for(i in a) {
        for (j in i) print("$j ")
        println()
    }
}
fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
    if(firstList.isEmpty() || secondList.isEmpty()) return arrayOf<IntArray>()

    val mx = max(firstList.last()[1], secondList.last()[1])
    val a = IntArray(mx + 1) { 0 }
    for(i in firstList){
        for(j in i[0]..i[1]) a[j]++
    }
    for(i in secondList){
        for(j in i[0]..i[1]) a[j]++
    }
    val ans = mutableListOf<IntArray>()
    var left = 0
    var right = 0
    while(right < mx){
        if(a[right] == 2){
            left = right
            while (a[right] == 2){
                right++
            }
            ans.add(intArrayOf(left, right-1))
        }
        right++
    }
    return ans.toTypedArray()
}