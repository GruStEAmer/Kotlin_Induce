package Leetcode

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    var tail = head
    while(tail != null && tail.`val` == `val`)
        tail = tail.next

    val node = tail

    if(tail != null) {
        while (tail?.next != null) {
            var n = tail.next
            while(n != null && n.`val` == `val`)
                n = n.next
            tail.next = n
            tail = tail.next
        }
    }
    else return null
    return node
}