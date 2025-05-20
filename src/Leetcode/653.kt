package Leetcode

fun main(){
    val hs: HashSet<Int> = HashSet()
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        if (root == null) return false
        if (hs.contains(k - root.`val`)) return true
        hs.add(root.`val`)

        return findTarget(root.left, k) || findTarget(root.right, k)
    }
}