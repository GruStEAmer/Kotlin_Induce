package Leetcode

fun main(){
    minimumPairRemoval(intArrayOf(2,2,-1,3,-2,2,1,1,1,0,-1))
}

fun minimumPairRemoval(nums: IntArray): Int {
    val head = TList(nums[0])
    var tail: TList? = head
    for(i in 1 until nums.size){
        tail?.next = TList(nums[i])
        tail?.next?.prev = tail
        tail = tail?.next!!
    }
    var counter = 0

    if(head.next == null) return 0
    tail = head.next!!

    while(tail?.next != null) {
        if (tail.prev!!.`val` > tail.`val`) {
            counter++
            tail.`val` += tail.next!!.`val`
            tail.next = tail.next?.next
            tail.next?.next?.prev = tail
        } else {
            tail = tail.next
        }
    }
    while(tail?.prev != null) {
        if(tail.`val` < tail.prev!!.`val`){
            tail.`val` += tail.prev!!.`val`
            tail.prev = tail.prev?.prev
            counter++
        }
        else tail = tail.prev
    }
    return counter
}
class TList(var `val`: Int){
    var next: TList? = null
    var prev: TList? = null
}
//    while(tail?.prev != null) {
//        if(tail.`val` < tail.prev!!.`val`){
//            tail.prev!!.`val` += tail.`val`
//            tail = tail.prev
//            counter++
//        }
//        else break
//    }