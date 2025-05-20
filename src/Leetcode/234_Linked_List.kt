package Leetcode

import java.util.Stack

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
class `234_Linked_List` {
    fun isPalindrome(head: ListNode?): Boolean {
        var header_size  = head
        var sz = 0
        while(header_size != null){
            header_size = header_size.next
            sz++
        }
        var header = head
        val s: Stack<Int> = Stack()
        if (header == null) return false
        else if (header.next == null) return true

        var i = 0
        val flag = sz % 2 == 1
        sz = sz / 2

        while (header != null) {
            if(flag)
                if(i == sz){
                    i++
                    header = header.next
                    continue
                }
            if (s.empty()) s.push(header.`val`)
            else if (s.lastElement() == header.`val` && i >= sz)
                s.pop()
            else s.push(header.`val`)

            header = header.next
            i++
        }
        if(s.empty()) return true
        return false
    }
}