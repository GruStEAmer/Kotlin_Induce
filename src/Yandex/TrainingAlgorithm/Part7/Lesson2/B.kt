package Yandex.TrainingAlgorithm.Part7.Lesson2


fun main() {
    val n:Int = readln().toInt()
    var k = 1
    while(k < n) k *= 2

    var j = 0
    val array:Array<Pair<Int,Int>> = Array(2 * k - 1) { Pair(Int.MIN_VALUE, Int.MIN_VALUE)}

    val r:List<Int> = readln().split(' ').map { it.toInt() }
    for(i in 0..< k)
        if(i < r.size)array[k + i - 1] = Pair(r[i], i)
        else array[k + i - 1] = Pair(Int.MIN_VALUE, i)

    for(i in 2 * k - 2 downTo 2 step 2){
        val j = i / 2 - 1
        if(array[i].first > array[i-1].first)
            array[j] = array[i]
        else array[j] = array[i-1]
    }
    val s = readln().toInt()
    repeat(s) {
        var (l, r) = readln().split(' ').map { it.toInt()}
        l--
        r--
        fun indexMax(a: Int, left: Int, right: Int):Pair<Int,Int> {
            if(r < left || right < l)
                return Pair(Int.MIN_VALUE, Int.MIN_VALUE)
            if(l <= left && right <= r) {
                return array[a]
            }
            val mid = (left + right)/2
            val leftValue = indexMax(2 * a + 1, left , mid)
            val rightValue = indexMax(2 * a + 2, mid + 1, right)
            return when{
                leftValue.first > rightValue.first -> leftValue
                else -> rightValue
            }
        }
        val  ans = indexMax(0,0,k-1)
        println("${ans.second + 1}")
    }
}