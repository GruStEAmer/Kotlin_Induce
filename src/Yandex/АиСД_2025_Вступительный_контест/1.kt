package Yandex.АиСД_2025_Вступительный_контест

fun main(){
    val a = readln().split(" ").map{ it->
        it.toInt()
    }
    val t = readln().split(" ").map{
        it.toInt()
    }
    val ans = mutableListOf<Int>()
    var now = 0
    for(i in t){
        if(now < i){
            now = i
        }
        now += a[1]
        ans.addLast(now)
    }
    for(i in ans) println(i)
}