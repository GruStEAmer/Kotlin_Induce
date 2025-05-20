package Leetcode

fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
    var a = headA
    var b = headB
    var counterA:Short = 0
    var counterB:Short = 0
    while(a != null) {
        counterA++
        a = a.next
    }
    while(b != null) {
        counterB++
        b = b.next
    }
    var a2 = headA
    var b2 = headB
    if(counterA > counterB){
        val counter = counterA - counterB
        for(i in 0..< counter){
            a2 = a2?.next
        }
    }
    else {
        val counter = counterB - counterA
        for(i in 0 ..< counter)
            b2 = b2?.next
    }
    while(true){
        if(a2 == b2) return a2
        a2 = a2?.next
        b2 = b2?.next
    }
}