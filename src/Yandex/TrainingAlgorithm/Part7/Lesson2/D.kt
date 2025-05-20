package Yandex.TrainingAlgorithm.Part7.Lesson2

import kotlin.math.max

fun main() {
    val k: Int = readln().toInt()
    var n: Int = 1
    while(n < k) n *= 2

    val array: IntArray = IntArray(2 * n - 1) { Int.MIN_VALUE }
    val r: List<Int> = readln().split(' ').map{ it.toInt() }
    for(i in 0..< k)
        array[n + i - 1] = r[i]
    for(i in 2 * n - 2 downTo 2 step 2){
        val j = i / 2 - 1
        array[j] = max(array[i], array[i-1])
    }
    var ans = ""
    val s = readln().toInt()
    repeat(s){
        val a = readln().split(' ')
        if("s" == a[0]){
            var l: Int = a[1].toInt()
            var r: Int = a[2].toInt()
            l--
            r--
            fun indexMax(a: Int, left:Int, right:Int): Int{
                if (r < left || right < l) {
                    return Int.MIN_VALUE
                }
                if (l <= left && right <= r) {
                    return array[a]
                }
                val mid = (left + right) / 2
                val leftResult = indexMax(2 * a + 1, left, mid)
                val rightResult = indexMax(2 * a + 2, mid + 1, right)

                return when {
                    leftResult < rightResult -> rightResult
                    else -> leftResult
                }
            }
            ans += indexMax(0,0,n-1).toString() + ' '
        }
        else if(a[0] == "u"){
            var index = a[1].toInt()
            index += n - 2
            val target = a[2].toInt()
            array[index] = target
            while(index > 0){
                index = index / 2 + index % 2 - 1
                array[index] = max(array[index * 2 + 1], array[index * 2 + 2])
            }
        }
    }
    println(ans)
}