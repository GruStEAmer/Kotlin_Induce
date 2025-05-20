package Leetcode

fun invertTree(root: TreeNode?): TreeNode? {
    if(root == null) return root

    fun dfs(node:TreeNode?) {
        if(node == null) return
        val tmp = node.left
        node.left = node.right
        node.right = tmp

        dfs(node.left)
        dfs(node.right)
    }
    dfs(root)
    return root
}