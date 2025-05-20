package Yandex.TrainingAlgorithm.Part7.Lesson4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val array = IntArray(n) { 0 }

    val r = reader.readLine().trim().split(' ').map { it.toInt() }
    if(n == 2){
        writer.write("0 0")
        reader.close()
        writer.close()
        return
    }
    var tail: ListNode? = ListNode(r[0], 0)
    var head: ListNode? = tail
    for(i in 1..< r.size){
        tail?.next = ListNode(r[i], i)
        tail?.next?.prev = tail
        tail = tail?.next
    }
    head?.prev = tail
    tail?.next = head

    var round = 1
    var count = n
    var flag = true

    while(flag){
        val deleted:MutableSet<Int> = mutableSetOf()
        flag = false
        var go = head
        if(count <= 2 )
            break
        for(i in 0..<count){
            if(count <= 2) break
            var x = go!!.prev!!.place
            var y = go!!.next!!.place

            var f = true
            for(i in deleted){
                if(i in x..go.place)
                    f = false
                if(i in go.place..y)
                    f = false
            }

            if((go.prev!!.`val` > go.`val` && go.next!!.`val` > go.`val`) && f){
                go.prev?.next = go.next
                go.next?.prev = go.prev
                if(array[go.place] == 0) {
                    array[go.place] = round
                    deleted.add(go.place)
                }
                flag = true
                count--
            }
            go = go.next

        }
        round++
    }
    //for(i in array) print("$i ")
    val aa = "2 1 7 1 2 6 5 1 2 3 1 2 4 9 1 7 1 5 1 4 3 2 1 6 1 3 1 2 8 2 1 4 1 2 3 5 1 6 1 0 4 2 1 3 5 6 1 7 1 2 3 8 1 2 3 4 1 2 1 9 3 1 2 6 3 1 2 4 1 5 1 3 1 2 10 1 2 1 3 1 0 1 4 2 1 3 0 2 1 0 0 1 2 0 4 1 3 2 1 8".split(' ').map{it.toInt()}
    for(i in 0..< array.size) {
        if(array[i] != aa[i]) print("${array[i]} ${aa[i]} ")
    }

    reader.close()
    writer.close()
}

class ListNode(var `val`: Int, var place: Int) {
    var prev: ListNode? = null
    var next: ListNode? = null
}