//РЕШЕНО
package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val num = reader.readLine().split(' ').map {
        it.toInt()
    }
    val l : MutableList<Int> = mutableListOf()
    var i = 0
    while(i < num.size){
        if(l.size < 2){
            l.addLast(num[i])
            i++
        }
        else {
            if(l[l.size-1] == num[i] && l[l.size - 2] == num[i]){
                l.removeLast()
                l.removeLast()
                i++
                while(i < num.size){
                    if(num[i] == num[i-1])
                        i++
                    else break
                }
            }
            else {
                l.addLast(num[i])
                i++
            }
        }
    }
    println("${num.size - l.size}")
}