package Leetcode

fun mergeNodes(head: ListNode?): ListNode? {
    var n = head
    val ans = ListNode(0)
    var tail = ans
    var sum = 0
    while(n != null){
        if(n.`val` != 0)
            sum += n.`val`
        else {
            if(sum > 0) {
                tail.next = ListNode(sum)
                tail = tail.next!!
            }
            sum = 0
        }
        n = n.next
    }
    return ans.next
}