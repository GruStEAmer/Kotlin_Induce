package Yandex.TrainingAlgorithm.Part7.Lesson3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = reader.readLine().trim()

    if(n == "1"){
        val x = reader.readLine()
        var pow = 1
        var counter = 1
        while(pow * 2 < x.length + counter){
            pow *= 2
            counter++
        }
        val ans = CharArray(x.length + counter + 1) {'1'}
        ans[0] = '0'
        while(pow > 0){
            ans[pow] = '0'
            pow /= 2
        }
        var j = 0
        for(i in 0..< ans.size)
            if(ans[i] == '1') {
                ans[i] = x[j]
                j++
            }

        var point = 1
        while (point < ans.size){
            var i = point
            var sum = 0
            while(i < ans.size){
                repeat(point){
                    if(i < ans.size){
                        sum +=  ans[i] - '0'
                        i++
                    }
                }
                i += point
            }
            ans[point] = (sum % 2 + '0'.code).toChar()
            point *= 2
        }
        print(ans)
    }
    else if(n == "2"){
        val ans = reader.readLine().trim().toCharArray()
        var point = 1
        var errorBit = 0
        while (point < ans.size){
            var i = point
            var sum = 0
            while(i < ans.size){
                repeat(point){
                    if(i < ans.size){
                        sum +=  ans[i] - '0'
                        i++
                    }
                }
                i += point
            }
            if(sum % 2 == 1) errorBit += point
            point *= 2
        }
        ans[errorBit] = if(ans[errorBit] == '0') '1' else '0'
        point = 1
        for(i in 1..< ans.size){
            if(i != point || i + 1 == ans.size) {
                print(ans[i])
            } else point *= 2
        }
    }

    reader.close()
    writer.close()
}