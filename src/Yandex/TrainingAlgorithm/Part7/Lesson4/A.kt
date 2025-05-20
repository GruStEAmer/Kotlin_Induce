package Yandex.TrainingAlgorithm.Part7.Lesson4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MyStack() {
    private var size = 0
    private var tail: ListNode? = null

    fun push(s : String ):String {
        val newNode = ListNode(s)
        if(tail != null)
            newNode.next = tail
        tail = newNode
        size++
        return "ok"
    }
    fun pop(): String {
        if(tail == null){
            return "error"
        }
        else {
            val s = tail!!.`val`
            size--
            tail = tail?.next
            return s
        }
    }
    fun back(): String {
        return if(tail == null) "error"
        else tail!!.`val`
    }
    fun size(): Int {
        return size
    }
    fun clear():String{
        size = 0
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



fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))


    val stack = MyStack()
    while(true){
        val r = reader.readLine().split(' ')
        when(r[0]) {
            "push" -> writer.write(stack.push(r[1]) + '\n')
            "pop" -> writer.write(stack.pop()+ '\n')
            "back" -> writer.write(stack.back()+ '\n')
            "size" -> writer.write("${stack.size()}\n" )
            "clear" -> writer.write(stack.clear()+ '\n')
            "exit" -> {
                writer.write(stack.exit())
                break
            }
        }
    }
    reader.close()
    writer.close()
}