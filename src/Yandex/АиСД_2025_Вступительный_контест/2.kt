package Yandex.АиСД_2025_Вступительный_контест



fun main(){
    val s = readln()
    val sz = s.length / 2 + s.length % 2
    val m = mutableMapOf<Char, Long>().toSortedMap()

    for(i in 0 until sz){
        m[s[i]] = m.getOrDefault(s[i], 0) + (s.length - i) * (i + 1)
    }
    val s1 = s.reversed()
    val sz1 = s.length - sz
    for(i in 0 until sz1){

        m[s1[i]] = m.getOrDefault(s1[i], 0) + (s.length - i) * (i + 1)
    }
    for(i in m) println("${i.key}: ${i.value}")
}