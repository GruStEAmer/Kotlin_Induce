package Leetcode

fun countNodes(root: TreeNode?): Int {
    if(root == null) return 0
    val l = countNodes(root.left)
    val r = countNodes(root.right)
    return l + r + 1
}