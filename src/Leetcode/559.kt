package Leetcode
class Node(var `val`: Int){
    var children: List<Node?> = listOf()
}

fun maxDepth(root: Node?): Int {
    var mx = 0
    if(root == null) return 0

    fun dfs(node:Node?, value: Int) {
        if(node == null) {
            return
        }
        val flag:Boolean = node.children.all { it == null}
        if(flag){
            if(value > mx) mx = value
            return
        }
        for(i in node.children){
            dfs(i, value+1)
        }
    }
    dfs(root, 0)
    return mx
}