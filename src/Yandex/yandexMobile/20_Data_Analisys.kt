//Решено!
package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n:Int = reader.readLine().toInt()
    val hm: SortedMap<String, Int> = HashMap<String,Int>().toSortedMap()

    for(i in 0 until n) {
        val a: List<String> = reader.readLine().split(' ')
        if(a[0] == "+") {
            if(hm.containsKey(a[2])) hm.put( a[2] , a[1].toInt() + hm[a[2]]!!)
            else
                hm[a[2]] = a[1].toInt()
        }
        else if(a[0] == "?") {
            var p:Pair<String, Int> = Pair(a[1] , 0)

            for(i in hm) {
                if(i.key.length >= a[1].length){
                    if (i.key.substring(0, a[1].length) == a[1]) {
                        if (i.value > p.second) p = Pair(i.key, i.value)
                    }
                }
            }
            println(p.first)
        }
    }
    println(hm)
    reader.close()
    writer.close()
}