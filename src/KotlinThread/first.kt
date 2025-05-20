package kotlinThread

import kotlin.concurrent.thread

fun main(){
    var a = 0
    var b = 0
    val th2 = thread{
        Thread.sleep(5000)
        repeat(5){
            println("a = $a")
            a++
        }


    }
    val th1 = thread{
        Thread.sleep(7000)
        repeat(5){
            println("b = $b")
            b++
        }

    }
    th2.join()
    th1.join()

}