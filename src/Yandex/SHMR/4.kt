package Yandex.SHMR

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val array = reader.readLine().split(' ').map { it.toInt() }.toMutableList()
    val hm = hashMapOf<Int,Int>().toSortedMap()
    val ans =  mutableListOf<Pair<Int,Int>>()

    for(i in 0..< array.size){
        hm[array[i]] = i
    }
    for(i in 0..< array.size){
        while(array[i] != n - i){
            val y = array[i] + 1

            array[i]++
            array[hm[y]!!]--

            ans.add(Pair(i+1, hm[y]!! + 1))
            hm[array[i]-1] = hm[y]
            hm[y] = i

        }
    }
    println(ans.size)
    for(i in ans) println("${i.first} ${i.second}")
    reader.close()
    writer.close()
}

