package Yandex.SHMR

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (k, z)= reader.readLine().split(' ').map { it.toInt() }
    val array = Array<IntArray>(k) {
        IntArray(z) { 0 }
    }
    val white = mutableListOf<Pair<Int,Int>>()
    val black = mutableListOf<Pair<Int,Int>>()
    repeat(reader.readLine().toInt()) {
        val (x,y) = reader.readLine().split(' ').map { it.toInt() - 1 }
        white.add(Pair(x,y))
        array[x][y] = 1
    }
    repeat(reader.readLine().toInt()) {
        val (x,y) = reader.readLine().split(' ').map { it.toInt() - 1 }
        black.add(Pair(x,y))
        array[x][y] = -1
    }

    val step = reader.readLine()
    var flag = "No"
    if(step == "white"){
        for(pos in white){
            if(pos.first + 2 < k && pos.second + 2 < z){
                if(array[pos.first + 1][pos.second + 1] == -1 && array[pos.first + 2][pos.second + 2] == 0){
                    flag = "Yes"
                    break
                }
            }
            if(pos.first + 2 < k && pos.second - 2 >= 0){
                if(array[pos.first + 1][pos.second - 1] == -1 && array[pos.first + 2][pos.second - 2] == 0){
                    flag = "Yes"
                    break
                }
            }
            if(pos.first - 2 >= 0 && pos.second + 2 < z){
                if(array[pos.first - 1][pos.second + 1] == -1 && array[pos.first - 2][pos.second + 2] == 0){
                    flag = "Yes"
                    break
                }
            }
            if(pos.first - 2 >= 0 && pos.second - 2 >= 0){
                if(array[pos.first - 1][pos.second - 1] == -1 && array[pos.first - 2][pos.second - 2] == 0){
                    flag = "Yes"
                    break
                }
            }
        }
    }
    else if(step == "black"){
        for(pos in black){
            if(pos.first + 2 < k && pos.second + 2 < z){
                if(array[pos.first + 1][pos.second + 1] == 1 && array[pos.first + 2][pos.second + 2] == 0){
                    flag = "Yes"
                    break
                }
            }
            if(pos.first + 2 < k && pos.second - 2 >= 0){
                if(array[pos.first + 1][pos.second - 1] == 1 && array[pos.first + 2][pos.second - 2] == 0){
                    flag = "Yes"
                    break
                }
            }
            if(pos.first - 2 >= 0 && pos.second + 2 < z){
                if(array[pos.first - 1][pos.second + 1] == 1 && array[pos.first - 2][pos.second + 2] == 0){
                    flag = "Yes"
                    break
                }
            }
            if(pos.first - 2 >= 0 && pos.second - 2 >= 0){
                if(array[pos.first - 1][pos.second - 1] == 1 && array[pos.first - 2][pos.second - 2] == 0){
                    flag = "Yes"
                    break
                }
            }
        }
    }
    println(flag)


    reader.close()
    writer.close()
}