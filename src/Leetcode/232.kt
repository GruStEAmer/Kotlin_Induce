package Leetcode

import java.util.*

class MyQueue() {
    private val start = Stack<Int>()
    private val end = Stack<Int>()
    fun push(x: Int) {
        start.push(x)
    }

    fun pop(): Int {
        if(end.isEmpty())
            while (start.isNotEmpty())
                end.push(start.pop())
        return end.pop()
    }

    fun peek(): Int {
        if(end.isEmpty())
            while(start.isNotEmpty())
                end.push(start.pop())
        return end.peek()
    }

    fun empty(): Boolean {
        return start.isEmpty() && end.isEmpty()
    }
}