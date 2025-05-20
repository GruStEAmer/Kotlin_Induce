//Не доработка. 16/47 тестов
package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val a:List<Int>  = reader.readLine().split(" ").map { it.toInt() }

    val inp = reader.readLine().split(" ").map{it.toLong()}.filter { it != 0.toLong() }
    val lst = mutableListOf<Long>()
    var ans:Long = 0

    if(inp.size == 0){
        writer.write("0")
    }
    else{
        lst.add(inp[0])
        for(i in 1..<inp.size){
            lst.add(inp[i].plus(lst.last()))
        }


        for(i in 0..<inp.size){
            if(inp[i] + i< inp.size){
                ans += inp[i] * inp[i] + lst[(inp[i]+ i).toInt()] - lst[i]
            }
            else{
                ans += inp[i] * inp[i] + lst.last() - lst[i]
            }

        }

        writer.write("$ans")
    }

    reader.close()
    writer.close()
}
//fun main(args: Array<String>) {
//    val reader = BufferedReader(InputStreamReader(System.`in`))
//    val writer = BufferedWriter(OutputStreamWriter(System.out))
//
//    val a:List<Int>  = reader.readLine().split(" ").map { it.toInt() }
//
//    val inp = reader.readLine().split(" ").map{it.toLong()}.filter { it != 0.toLong() }
//
//    var ans:Long = 0
//    for(i in 0..<inp.size){
//        var a = inp[i]
//        var k:Long = 0
//
//        var j = 1
//        while(j <= a){
//            if(i + j > inp.size - 1)
//                break
//            k+= inp[i + j]
//            j++
//        }
//        ans += inp[i]*inp[i] + k
//    }
//    writer.write("$ans")
//    reader.close()
//    writer.close()
//}