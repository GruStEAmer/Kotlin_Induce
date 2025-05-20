package Yandex.АиСД_2025_Вступительный_контест

fun main(){
    val T = readln().toInt()
    val ans = mutableListOf<Int>()
    for(i in 0..< T){
        val m = mutableMapOf<Int, Pair<Int,Int>>().toSortedMap()
        val n = readln().toInt()

        val l1 = readln().split(" ").map{
            it.toInt()
        }
        val l2 = readln().split(" ").map{
            it.toInt()
        }

        var j = 0
        readln().split(" ").map{
            it.toInt()
        }.forEach{
            m[it] = Pair(l1[j],l2[j])
            j++
        }

        if(n == 1){
            ans.addLast(0)
            continue
        }

        var x = true
        var y = true
        for(i in 0.. n - 2){
            if(m[i]!!.first < m[i+1]!!.first){
                x = false
            }
            if(m[i]!!.second < m[i+1]!!.second){
                y = false
            }
        }
        if(x){
            ans.addLast(0)
            break
        }
        if(!x && !y){
            ans.addLast(-1)
            break
        }
        else{
            var day = 1
            while(!x){
                x = true
                for(i in 0 until n){
                    m[i] = Pair(m[i]!!.first + m[i]!!.second, m[i]!!.second)
                }
                for(i in 0.. n - 2){
                    if(m[i]!!.first < m[i+1]!!.first){
                        x = false
                    }
                }
                day++
                if(day > 1000){
                    ans.addLast(-1)
                    break
                }
            }
            if(day <= 1000)
                ans.addLast(day)
        }
    }
    for(i in ans) println(i)
}