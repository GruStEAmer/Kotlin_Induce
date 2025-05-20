package Solutions

fun main(){
    val s:String = readln()
    val t:String = readln()

    val mp:MutableMap<Char,Char> = mutableMapOf()

    for(i in 0..< s.length){
        if(mp.containsKey(s[i]) || mp.containsValue(t[i])){
            if(!(mp[s[i]] == t[i])){
                println("false")
            }
        }
        else{
            mp[s[i]] = t[i]
        }
    }
    println("true")
}