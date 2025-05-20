package Leetcode

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var list1 = l1
    var list2 = l2

    var a = 0
    val ans = ListNode(0)
    var tail = ans
    while(list1 != null || list2 != null) {
        if(list1 == null && list2 == null) break
        if(list1 == null) list1 = ListNode(0)
        if(list2 == null) list2 = ListNode(0)

        if (list1.`val` + list2.`val` + a == 0) {
            tail.next = ListNode(0)
            a = 0
        } else {
            tail.next = ListNode((list1.`val` + list2.`val` + a) % 10)
            a = (list1.`val` + list2.`val` + a) / 10
        }
        tail = tail.next!!
        list1 = list1.next
        list2 = list2.next
    }
    if(a != 0) {
        tail.next = ListNode(1)
        tail = tail.next!!
    }
    return ans.next
}