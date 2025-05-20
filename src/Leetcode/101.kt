package Leetcode

fun isSymmetric(root: TreeNode?): Boolean {
    if(root == null) return true

    val l = root.left
    val r = root.right

    fun dfs(p: TreeNode?, q: TreeNode?): Boolean {
        if((p == null || q == null) && (p != null || q != null)) return false
        else if(p == null) return true

        if(p.`val` != q?.`val`) return false
        val a = isSameTree(p?.left, q?.right)
        val b = isSameTree(p?.right, q?.left)

        return a && b
    }

    return dfs(l, r)
}