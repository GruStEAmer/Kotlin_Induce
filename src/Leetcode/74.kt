package Leetcode

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if(matrix.size == 1 && matrix[0].size == 1) return matrix[0][0] == target
    if(matrix.size == 1) return matrix[0].any{ it == target}
    if(matrix[0].size == 1) return matrix.any{ it[0] == target}
    var i = 0
    var j = matrix[0].size - 1
    while(i < matrix.size && j > 0){
        if(target > matrix[i][j])
            i++
        else if(target < matrix[i][j]) j--
        else if(target == matrix[i][j]) return true
    }
    return false
}