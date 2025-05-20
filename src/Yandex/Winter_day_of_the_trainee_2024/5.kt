package Yandex.Winter_day_of_the_trainee_2024
//5. Тетрамино
//Зачтено
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter



fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val m: MutableList<List<Char>> = mutableListOf()
    for(i in 0 ..< 8){
        m.addLast(reader.readLine().toList())
    }
    var counter = 0
    for(i in 0..< 8) {
        for(j in 0..< 8){
            if(j in 1..6 && i < 7){
                if(m[i][j] == '.' && m[i][j-1] == '.' && m[i][j+1] == '.' && m[i+1][j] == '.') counter++
            }
            if(j in 1..6 && i > 0){
                if(m[i][j] == '.' && m[i][j-1] == '.' && m[i][j+1] == '.' && m[i-1][j] == '.') counter++
            }
            if(i in 1..6 && j < 7){
                if(m[i][j] == '.' && m[i-1][j] == '.' && m[i+1][j] == '.' && m[i][j+1] == '.') counter++
            }
            if(i in 1..6 && j > 0){
                if(m[i][j] == '.' && m[i-1][j] == '.' && m[i+1][j] == '.' && m[i][j-1] == '.') counter++
            }
        }
    }
    writer.write("$counter")
    reader.close()
    writer.close()
}