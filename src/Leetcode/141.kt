package Leetcode

fun main(){

}
fun hasCycle(head: ListNode?): Boolean {
    var first = head
    var second = head

    while(first != null && second != null){
        first = first.next
        second = second.next?.next
        if(first == second) return true
    }
    return false
}