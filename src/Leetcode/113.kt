package Leetcode


fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    val ans:MutableList<List<Int>> = mutableListOf()

    fun dfs(node: TreeNode? ,l: MutableList<Int>) {
        if(node == null) {
            return
        }
        val newL: MutableList<Int> = l.toMutableList()
        newL.add(node.`val`)

        if(node.left == null && node.right == null){
            if(newL.sum() == targetSum)
                ans.add(newL)
            return
        }


        dfs(node.left, newL)
        dfs(node.right, newL)
    }

    dfs(root, mutableListOf())
    return ans
}