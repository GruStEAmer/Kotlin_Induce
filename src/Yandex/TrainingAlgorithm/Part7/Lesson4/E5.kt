package Yandex.TrainingAlgorithm.Part7.Lesson4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))
    
    val n = reader.readLine().toInt()
    val a = reader.readLine().split(" ").map { it.toInt() }
    
    val array = Array(n) { i ->
        Node(i, a[i], (i - 1 + n) % n, (i + 1) % n)
    }
    val answer = IntArray(n) { 0 }
    var count = n

    var round = 1
    val delete = LinkedList<Int>()



    for (i in 0 until n) {
        if (isWeak(array, i)) delete.add(i)
    }

    while (count > 2 && delete.isNotEmpty()) {
        val nextRemove = LinkedList<Int>()
        val changed = mutableSetOf<Int>()
        while (delete.isNotEmpty()) {
            val i = delete.poll()
            if (!array[i].alive) continue
            answer[i] = round
            array[i].alive = false
            count--
            val l = array[i].prev
            val r = array[i].next
            array[l].next = r
            array[r].prev = l
            changed.add(l)
            changed.add(r)
        }
        for (i in changed) {
            if (array[i].alive && isWeak(array, i)) nextRemove.add(i)
        }
        delete.clear()
        delete.addAll(nextRemove)
        round++
    }

    for(i in answer) writer.write("$i ")
    reader.close()
    writer.close()
}

data class Node(
    val index: Int,
    val value: Int,
    var prev: Int,
    var next: Int,
    var alive: Boolean = true
)
fun isWeak(array: Array<Node>,i: Int): Boolean {
    if (!array[i].alive) return false
    val l = array[i].prev
    val r = array[i].next
    return array[l].alive && array[r].alive &&
            array[i].value < array[l].value &&
            array[i].value < array[r].value
}