package Yandex.TrainingAlgorithm.Part7.Lesson4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Deque () {
    private var size = 0
    private var head:ListNode? = null
    private var tail:ListNode? = null

    fun pushFront(s: String): String {
        val newNode = ListNode(s)
        size++

        if(head == null){
            head = newNode
            tail = head
        }
        else{
            newNode.next = head
            head?.prev = newNode
            head = newNode
        }
        return "ok"
    }
    fun pushBack(s: String) : String {
        val newNode = ListNode(s)
        size++

        if(tail == null){
            tail = newNode
            head = tail
        }
        else{
            newNode.prev = tail
            tail?.next = newNode
            tail = newNode
        }
        return "ok"
    }
    fun popFront(): String {
        if (head == null) return "error"

        size--
        val s = head!!.`val`
        head = head?.next

        if (head == null) {
            tail = null
        } else {
            head?.prev = null
        }

        return s
    }

    fun popBack(): String {
        if (tail == null) return "error"

        size--
        val s = tail!!.`val`
        tail = tail?.prev

        if (tail == null) {
            head = null
        } else {
            tail?.next = null
        }

        return s
    }
    fun front(): String {
        if(head != null)
            return head!!.`val`
        else return "error"
    }
    fun back(): String {
        if(tail != null)
            return tail!!.`val`
        else return "error"
    }
    fun size():Int = size
    fun clear():String {
        size = 0
        head = null
        tail = null
        return "ok"
    }
    fun exit(): String {
        return "bye"
    }

    private class ListNode(var `val`: String) {
        var prev: ListNode? = null
        var next: ListNode? = null
    }
}


fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val deque = Deque()
    while(true) {
        val r = reader.readLine().split(' ')
        when(r[0]) {
            "push_front" -> writer.write(deque.pushFront(r[1]) + '\n')
            "push_back" -> writer.write(deque.pushBack(r[1]) + '\n')
            "pop_front" -> writer.write(deque.popFront() + '\n')
            "pop_back" -> writer.write(deque.popBack() + '\n')
            "front" -> writer.write(deque.front() + '\n')
            "back" -> writer.write(deque.back() + '\n')
            "size" -> writer.write("${deque.size()}\n")
            "clear" -> writer.write( deque.clear() + '\n')
            "exit" -> {
                writer.write(deque.exit())
                break
            }
        }
    }

    reader.close()
    writer.close()
}