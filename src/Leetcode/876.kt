package Leetcode

fun middleNode(head: ListNode?): ListNode? {
    if(head == null) return null
    if(head.next == null) return head

    var one = head?.next
    var two = head?.next?.next
    var counter = 0
    while(two != null){
        counter++
        two = two.next
        if(two != null)
            counter++
        two = two?.next

        if(two != null )one = one?.next
    }
    if(counter %  2 == 0 && counter != 0)
        one = one?.next
    return one
}