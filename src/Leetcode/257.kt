package Leetcode

fun binaryTreePaths(root: TreeNode?): List<String> {
    if(root == null) return listOf<String>()

    val a: MutableList<String> = mutableListOf()

    fun dfs(node: TreeNode?, s:String){
        if(node == null) return

        val newS = s + "->${node.`val`}"
        if(node.left == null && node.right == null){
            a.add(newS)
            return
        }

        dfs(node.left, newS)
        dfs(node.right, newS)
    }
    dfs(root, "${root.`val`}")
    return a
}