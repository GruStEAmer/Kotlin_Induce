package Yandex.TrainingAlgorithm.Part7.Lesson2


fun main() {
    val n = readln().toInt()
    var k = 1
    while(k < n) k *= 2
    val array = Array<Pair<Int,Int>>( 2 * k - 1) { Pair(Int.MIN_VALUE,1) }
    val r = readln().split(' ').map{it.toInt()}

    for(i in 0 until n)
        array[k + i - 1] = Pair(r[i],1)


    for(i in 2 * k -2 downTo 2 step 2){
        val j = i / 2 - 1
        if(array[j * 2 + 1].first == array[(j+1) * 2].first)
            array[j] = Pair(array[(j+1) * 2].first, array[(j+1) * 2].second + array[j * 2 + 1].second)
        else array[j] = if(array[j * 2 + 1].first > array[(j+1) * 2].first) array[j * 2 + 1] else array[(j+1) * 2]
    }
    val s = readln().toInt()
    for(i in 0..< s) {
        var (l, r) = readln().split(' ').map{it.toInt()}
        l--
        r--
        fun maxValue(a: Int, left:Int, right:Int): Pair<Int,Int>{
            if (r < left || right < l) {
                return Pair(Int.MIN_VALUE, 0)
            }
            if (l <= left && right <= r) {
                return array[a]
            }
            val mid = (left + right) / 2
            val leftResult = maxValue(2 * a + 1, left, mid)
            val rightResult = maxValue(2 * a + 2, mid + 1, right)

            return when {
                leftResult.first > rightResult.first -> leftResult
                leftResult.first < rightResult.first -> rightResult
                else -> Pair(leftResult.first, leftResult.second + rightResult.second)
            }
        }
        val ans = maxValue(0, 0, k - 1)
        println("${ans.first} ${ans.second}")
    }
}