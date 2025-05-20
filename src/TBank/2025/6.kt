package TBank.`2025`

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val r = reader.readLine().split(' ').map { it.toInt()}

    var head = ListNode(r[0])
    var tail = head
    for(i in 1..< r.size){
        tail.next = ListNode(r[i])
        tail.next!!.prev = tail
        tail = tail.next!!
    }
    tail.next = head
    head.prev = tail
    var count = 0
    var answer = 0L

    while(n - count > 2){
        tail = head
        var a = Pair(head, 0)
        for(i in 0..< n - count){
            if(abs(tail.`val` - tail.next!!.`val`) > a.second) {
                a = Pair(tail, abs(tail.`val` - tail.next!!.`val`))
            }
            tail = tail.next!!
        }
        if(a.first == head){
            answer += abs(a.second)
            head.prev!!.next = head.next!!.next
            head.next!!.next!!.prev = head.prev
            head = head.next!!.next!!
            count += 2
        }
        else {
            val x = a.first
            answer += abs(a.second)
            x.prev?.next = x.next?.next
            x.next?.next?.prev = x.prev
            count += 2
        }
    }
    if(head != head.next)
        answer += abs(head.`val` - head.next!!.`val`)
    writer.write("$answer")

    reader.close()
    writer.close()
}
class ListNode(var `val`: Int){
    var next: ListNode? = null
    var prev: ListNode? = null
}