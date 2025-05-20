package Leetcode

import kotlin.math.abs

fun isBalanced(root: TreeNode?): Boolean {
    if(root == null) return true

    fun dfs(node: TreeNode?, count: Int): Int {
        if(node == null) return count

        if(node.left == null && node.right == null)
            return count

        val right = dfs(node.right, count + 1)
        val left = dfs(node.left, count + 1)

        return abs(right - left)
    }
    val a = dfs(root, 0)
    return a < 2
}