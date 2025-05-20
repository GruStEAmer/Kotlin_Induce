package Leetcode

fun preorderTraversal(root: TreeNode?): List<Int> {
    if(root == null) return listOf<Int>()
    val l: MutableList<Int> = mutableListOf()

    fun dfs(node: TreeNode?) {
        if(node == null) return
        l.add(node.`val`)
        if((node.left == null && node.right == null)) {
            return
        }
        dfs(node.left)
        dfs(node.right)
    }
    dfs(root)
    return l
}