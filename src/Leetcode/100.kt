package Leetcode

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if((p == null || q == null) && (p != null || q != null)) return false
    else if(p == null) return true

    if(p.`val` != q?.`val`) return false
    val a = isSameTree(p?.left, q?.left)
    val b = isSameTree(p?.right, q?.right)

    return a && b
}