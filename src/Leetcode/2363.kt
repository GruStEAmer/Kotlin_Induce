package Leetcode

fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {
    val hm = hashMapOf<Int,Int>().toSortedMap(compareBy{ it })
    for(i in items1)
        hm[i[0]] = hm.getOrDefault(i[0], 0) + i[1]
    for(i in items2)
        hm[i[0]] = hm.getOrDefault(i[0], 0) + i[1]

    return hm.toList().map { it -> listOf(it.first, it.second)}
}