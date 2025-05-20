package Leetcode

fun findSecondMinimumValue(root: TreeNode?): Int {
    if (root == null) return -1
    val a = intArrayOf(root.`val`, Int.MAX_VALUE)
    var flag = true
    fun dfs(node: TreeNode?){
        if(node == null) return
        if (a[0] > node.`val`) {
            a[1] = a[0]
            a[0] = node.`val`
        }
        else if(a[0] != node.`val`) {
            if (a[1] >= node.`val`) a[1] = node.`val`
            if(node.`val` == Int.MAX_VALUE) flag = false
        }

        if (node.left == null && node.right == null)
            return
        dfs(node.left)
        dfs(node.right)
    }
    dfs(root)
    return if(a[1] == Int.MAX_VALUE && flag) -1 else a[1]
}