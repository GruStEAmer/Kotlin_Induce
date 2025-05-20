//Зачтено
package Yandex.yandexMobile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val sz:Int = reader.readLine().toInt()
    val s:String = reader.readLine()

    val stack: Stack<Char> = Stack()

    if(sz % 2 == 1) writer.write("0")
    else{
        s.forEach {
            if(!stack.isEmpty()){
                if(stack.lastElement() == it)
                        stack.removeLast()
                else
                    stack.addLast(it)
            }
            else stack.addLast(it)
        }

        if(stack.isEmpty()) writer.write("1")
        else writer.write("0")
    }

    reader.close()
    writer.close()
}