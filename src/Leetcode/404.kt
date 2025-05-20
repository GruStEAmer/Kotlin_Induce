package Leetcode

fun sumOfLeftLeaves(root: TreeNode?): Int {
    if(root == null) return 0

    var sum = 0
    fun dfs(node: TreeNode?, value: Int) {
        if (node == null) return

        if(node.left == null && node.right == null) {
            if (value == -1)
                sum += node.`val`
            return
        }

        dfs(node.left, -1)
        dfs(node.right, 1)
    }
    dfs(root, 0)
    return sum
}