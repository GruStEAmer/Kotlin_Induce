package Leetcode

class TreeNode(var `val`: Int) {
    var left:TreeNode? = null
    var right:TreeNode? = null
}

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if(root == null) return false

    if(root.left == null && root.right == null)
        return targetSum == root.`val`

    val currentSum = targetSum - root.`val`
    return hasPathSum(root.left, currentSum) || hasPathSum(root.right, currentSum)

}
