package Leetcode

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val head:ListNode = ListNode(0)
    var current:ListNode? = head
    var l1 = list1
    var l2 = list2

    while(l1 != null || l2 != null){
        if(l1 == null){
            while(l2 != null){
                current?.next = l2
                l2 = l2.next
                current = current?.next
            }
        }
        else if(l2 == null){
            while(l1 != null){
                current?.next = l1
                l1 = l1.next
                current = current?.next
            }
        }
        else {
            if(l1.`val` > l2.`val`){
                current?.next = l2
                l2 = l2.next
            }
            else {
                current?.next = l1
                l1 = l1.next
            }
            current = current?.next
        }
    }
    return head.next
}

fun main() {
    var l:ListNode? = ListNode(1)
    l?.next = ListNode(2)
    //l?.next!!.next = ListNode(4)
    var l1:ListNode? = ListNode(0)
    //l1?.next = ListNode(2)
    //l1?.next!!.next = ListNode(3)
    var n = mergeTwoLists(l,l1)
    while(n != null){
        println("${n.`val`}")
        n = n.next
    }
}
