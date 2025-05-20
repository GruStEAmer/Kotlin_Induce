package Yandex.TrainingAlgorithm.Part7.Lesson4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Queue() {
    private var size = 0
    private var tail: ListNode? = null
    private var head: ListNode? = null

    fun push(s: String): String {
        val newNode = ListNode(s)
        size++

        if (tail == null) {
            tail = newNode
            head = tail
        } else {
            tail?.next = newNode
            tail = newNode
        }
        return "ok"
    }

    fun pop(): String {
        if (head == null) return "error"

        size--
        val s = head!!.`val`
        head = head?.next

        if (head == null) {
            tail = null
        }

        return s
    }

    fun front(): String {
        return head?.`val` ?: "error"
    }
    fun size(): Int {
        return size
    }
    fun clear(): String {
        size = 0
        head = null
        tail = null
        return "ok"
    }
    fun exit(): String {
        return "bye"
    }

    class ListNode(var `val`: String) {
        var next: ListNode? = null
    }
}

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val queue = Queue()
    while(true) {
        val r = reader.readLine().split(' ')
        when(r[0]) {
            "push" -> writer.write(queue.push(r[1]) + '\n')
            "pop" -> writer.write(queue.pop() + '\n')
            "front" -> writer.write(queue.front() + '\n')
            "size" -> writer.write("${queue.size()}\n")
            "clear" -> writer.write( queue.clear() + '\n')
            "exit" -> {
                writer.write(queue.exit())
                break
            }
        }
    }

    reader.close()
    writer.close()
}