package Yandex.YandexCodeRun

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().toInt()
    val l:List<MutableList<Double>> = mutableListOf()

    var ans  = ""
    for(i in 0 until n){
        val stack: Stack<Double> = Stack()
        val lst = mutableListOf<Double>()
        val s = reader.readLine().split(" ").map{it->
            it.toDouble()
        }.drop(1)
        for(i in s){
            if(stack.empty())
                stack.push(i)
            else if(stack.lastElement() > i || i.equals(stack.lastElement()))
                stack.push(i)
            else if(stack.lastElement() < i){
                while(!stack.empty()){
                    lst.addLast(stack.lastElement())
                    stack.pop()
                }
                stack.push(i)
            }
        }
        while(!stack.empty()){
            lst.addLast(stack.lastElement())
            stack.pop()
        }
        if(lst.windowed(2).all{ (a,b)->
            a <= b
            })
            ans +="1\n"
        else ans += "0\n"
    }
    writer.write(ans)
    reader.close()
    writer.close()
}