package Leetcode

import sun.swing.MenuItemLayoutHelper.max
import java.util.*

fun largestValues(root: TreeNode?): List<Int> {
    val answer = mutableListOf<Int>()
    if(root == null)
         return answer

    val q: Queue<TreeNode> = LinkedList<TreeNode>()
    q.offer(root)

    var counter = 1
    while(q.isNotEmpty()){
        val z = counter
        counter = 0
        var maximum = Int.MIN_VALUE
        repeat(z){
            val x = q.poll()
            if(x.left != null) {
                q.offer(x.left)
                counter++
            }
            if(x.right != null) {
                q.offer(x.right)
                counter++
            }
            maximum = max(maximum, x.`val`)
        }
        answer.add(maximum)
    }
    return answer
}