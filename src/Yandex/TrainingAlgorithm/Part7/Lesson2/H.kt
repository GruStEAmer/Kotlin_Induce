package Yandex.TrainingAlgorithm.Part7.Lesson2

import kotlin.math.max

fun main() {
    val n = readln().toInt()
    var k = 1
    while(k < n) k *= 2

    val array = LongArray(2 * k - 1) { Long.MIN_VALUE }
    val r = readln().split(' ').map { it.toLong() }
    for(i in 0..< n){
        array[k+i-1] = r[i]
    }
    for(i in 2 * k - 2 downTo 2 step 2){
        val j = i / 2 - 1
        array[j] = max(array[i], array[i-1])
    }

    var ans = ""
    repeat(readln().toInt()) {
        val a = readln().split(' ')
        if(a[0] == "g"){
            val b = a[1].toInt()
            ans += array[k + b - 2].toString() + ' '
        }
        else if(a[0] == "a"){
            val l = a[1].toInt() - 1
            val r = a[2].toInt() - 1
            val target = a[3].toLong()

            for(i in l..r)
                array[k + i - 1] += target
        }
    }
    println(ans)
}