package Leetcode

fun main() {

}

class `111` {

    var ans = Int.MAX_VALUE
    fun minDepth(root: TreeNode?): Int {
        if(root == null) return 0
        dfs(root, 1)
        return ans
    }
    fun dfs(node:TreeNode?, s:Int ){
        if(node == null) return

        val newS = s + node.`val`
        if(node.left == null && node.right == null){
            if(newS < ans) ans = newS
            return
        }
        dfs(node.left, newS)
        dfs(node.right, newS)
    }
}