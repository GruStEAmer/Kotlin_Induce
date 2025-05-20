package Leetcode

fun main() {
    val a = averageWaitingTime(
        arrayOf(intArrayOf(5,2), intArrayOf(5,4))
    )
    println("$a")
}

fun averageWaitingTime(customers: Array<IntArray>): Double {
    var time = customers[0][0].toLong()
    var timeWaiting = 0L

    for(i in customers) {
        if(i[0] >= time) time = i[0].toLong()
        time += i[1]
        timeWaiting += time - i[0]
    }
    return timeWaiting.toDouble() / customers.size
}