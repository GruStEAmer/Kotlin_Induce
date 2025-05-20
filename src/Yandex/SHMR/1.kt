package Yandex.SHMR

fun main() {
    val n = readln().toInt()
    val s = readln()
    val a = readln().split(' ').map{ it.toLong()}

    if(n > 1){
        val hm = hashMapOf<Char, Long>()
        hm[s[0]] = a[0]
        var mx = Pair(s[0], a[0])
        for(i in 1..<n){

            if (mx.second <= a[i] - a[i-1]) mx = Pair(s[i], a[i]-a[i-1])
        }
        println("${mx.first}")
    }
    else println(s)
}