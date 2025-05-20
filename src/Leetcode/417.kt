package Leetcode

import java.util.*

fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    val szX = heights.size
    val szY = heights[0].size
    val ans = mutableListOf<List<Int>>()


    for(i in 0 until szX) {
        for(j in 0 until szY) {
            val visited = Array(szX) {
                BooleanArray(szY) { true }
            }
            val q:Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
            q.offer(Pair(i, j))

            var pacific = false
            var atlantic = false

            if((i == 0 || j == 0)){
                pacific = true
            }
            if( i == szX-1 || j == szY-1)
                atlantic = true
            if(pacific && atlantic){
                ans.add(listOf(i,j))
                continue
            }

            loop@while(q.isNotEmpty()) {
                val (x, y) = q.poll()

                val xPos = arrayOf(-1, 1, 0, 0)
                val yPos = arrayOf(0, 0 , -1, 1)

                for(k in 0..3){
                    val xNew = x + xPos[k]
                    val yNew = y + yPos[k]

                    if(xNew in 0..< szX && yNew in 0..< szY) {
                        if (heights[xNew][yNew] <= heights[x][y]) {

                            if(visited[xNew][yNew]) {
                                q.offer(Pair(xNew, yNew))
                                visited[xNew][yNew] = false
                            }
                            if((xNew == 0 || yNew == 0))
                                pacific = true
                            if((xNew == szX-1 || yNew == szY-1))
                                atlantic = true
                        }
                        if(pacific && atlantic){
                            ans.add(listOf(i,j))
                            break@loop
                        }
                    }

                }
            }
        }
    }
    return ans
}