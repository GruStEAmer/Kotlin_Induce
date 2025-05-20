//РЕШЕНО
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

    val hm:HashMap<String, Int> = hashMapOf<String, Int>().apply{
        put("LEFT", -1 )
        put("RIGHT" , 1)
        put("TOP" , -2)
        put( "BOTTOM" , 2)
    }

    val a: MutableList<String> = mutableListOf<String>().apply {
        addLast("TOP 40")
        addLast("RIGHT 10")
        addLast("LEFT 30")
        addLast("BOTTOM 40")

    }//reader.readLines()
    val s: Stack<Pair<String, Int>> =  Stack()

    for(i in a) {
        val k = i.split(' ')
        val j = Pair(k[0],k[1].toInt())

        if(s.isEmpty())
            s.push(j)
        else{
            if(s.last().first == j.first){
                val p = Pair(s.last().first, s.last().second + j.second)
                s.pop()
                s.push(p)
            }
            else if((hm[s.last().first]?.plus(hm[j.first]!!)) == 0) {
                if (s.last().second > j.second) {
                    val p = Pair(s.last().first, s.last().second - j.second)
                    s.pop()
                    s.push(p)
                } else if (s.last().second < j.second) {
                    val p = Pair(j.first, j.second - s.last().second)
                    s.pop()
                    s.push(p)
                } else s.pop()
            }
            else s.push(j)
        }
    }
    for(i in s) writer.write("${i.first} ${i.second}\n")
    reader.close()
    writer.close()
}