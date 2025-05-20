package Leetcode

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null

    var sz = 1
    var tail = head
    while (tail?.next != null) {
        sz++
        tail = tail.next
    }

    val s = k % sz
    if (s == 0) return head  // нет необходимости вращать

    var newTail = head
    for (i in 0 until sz - s - 1) {
        newTail = newTail?.next
    }

    val newHead = newTail?.next
    newTail?.next = null
    tail?.next = head

    return newHead
}