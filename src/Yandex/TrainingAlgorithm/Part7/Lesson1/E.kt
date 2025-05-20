package Yandex.TrainingAlgorithm.Part7.Lesson1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n,m) = reader.readLine().split(' ').map{it.toInt()}

    val l = IntArray(m+1) {-1}
    l[0] = 0

    val list1 = reader.readLine().split(' ').map{ it.toInt()}
    val list2 = reader.readLine().split(' ').map{ it.toInt()}
    val sz = list1.size
    for(i in 0..< sz){
        var j = m
        while(j >= 0) {
            if(l[j] != -1 && j + list1[i] <= m){
                if(l[j + list1[i]] < l[j] + list2[i]){
                    l[j + list1[i]] = l[j] + list2[i]
                }
            }
            j--
        }
    }
    var j = m
    println("${l.max()}")

    reader.close()
    writer.close()
}