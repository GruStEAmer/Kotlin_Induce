package Yandex.YandexCodeRun

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = reader.readLine().split(' ').map { it.toInt() }
    val matrix = Array(n) {
        IntArray(m) { 0 }
    }
    for(i in 0 until n){
        val r = reader.readLine().split(' ').map{ it.toInt()}
        for(j in 0 until m){
            matrix[i][j] = r[j]
        }
    }
    val ans = Array(n) {
        IntArray(m) { 0 }
    }
    ans[0][0] = matrix[0][0]
    for(i in 1 until n){
        ans[i][0] = matrix[i][0] + ans[i-1][0]
    }
    for(j in 1 until m){
        ans[0][j] = matrix[0][j] + ans[0][j-1]
    }

    for(i in 1 until n){
        for(j in 1 until m){
            ans[i][j] = matrix[i][j] + min(ans[i-1][j] , ans[i][j-1])
        }
    }
    print(ans[n-1][m-1])
    reader.close()
    writer.close()
}