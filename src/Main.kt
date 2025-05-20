import java.io.File
import java.util.Stack

fun main(){
    val a = Stack<Pair<String, Int>>()
    val f = File("file.txt").readLines()
    f.forEach{
        val k = it.split(" ")
        var pair = Pair(k[0],k[1].toInt())
        if(a.isEmpty()){
            a.push(pair)
        }
        else{
            if(pair.first == a.lastElement().first){
                pair = Pair(pair.first,a.lastElement().second + pair.second)
                a.pop()
                a.push(pair)
            }
            else if((pair.first == "TOP" && a.lastElement().first == "BOTTOM") ||
                (pair.first == "BOTTOM" && a.lastElement().first == "TOP") ||
                (pair.first == "LEFT" && a.lastElement().first == "RIGHT") ||
                (pair.first == "RIGHT" && a.lastElement().first == "LEFT")){
                if(pair.second > a.lastElement().second){
                    pair = Pair(pair.first,pair.second - a.lastElement().second)
                    a.pop()
                    a.push(pair)
                }
                else if(pair.second < a.lastElement().second){
                    pair = Pair(a.lastElement().first, a.lastElement().second - pair.second)
                    a.pop()
                    a.push(pair)
                }
                else if(pair.second == a.lastElement().second){
                    a.pop()
                }
            }
            else{
                a.push(pair)
            }
        }
    }
    a.forEach{
        println("${it.first} ${it.second}")
    }
}