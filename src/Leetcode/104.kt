package Leetcode

fun maxDepth(root: TreeNode?): Int {
    var max = 0
    fun dfs(node: TreeNode?, m:Int) {
        if(node == null) return
        if(node.left == null && node.right == null){
            max = if(max > m) max else m
            return
        }
        val newM = m+1
        dfs(node.left, newM)
        dfs(node.right, newM)
    }
    dfs(root,0)
    return max
}