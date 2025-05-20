package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n:Int = reader.readLine().toInt()

    var lvl:Long = 1L
    var hit = 0

    val mp:HashMap<Long,MutableSet<Long>> = hashMapOf()

    var j:Long = 1L;
    for(i in reader.readLine().split(" ")){
        val k: Long = i.toLong()
        if(!mp.containsKey(k)){
            mp[k] = mutableSetOf()
        }
        mp[k]!!.add(j)
        j++
    }

    var ans:String = ""

    for(i in mp){
        if(lvl >= i.key){
            i.value.forEach{
                ans += "$it "
                if(lvl < 2 * i.key) hit++
                if(hit == 3){
                    hit = 0
                    lvl--
                }
                lvl++
            }
        }
        else{
            writer.write("Impossible")
            reader.close()
            writer.close()
            return
        }
    }
    ans = ans.substring(0,ans.length-1)
    writer.write("Possible\n$ans")

    reader.close()
    writer.close()
}