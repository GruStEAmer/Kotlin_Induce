package Yandex.Contest_October_2024

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val NT = reader.readLine().split(" ").map{
        it.toInt()
    }
    val n_days = reader.readLine().split(" ").map{
        it.toInt()
    }

    var start_p = reader.readLine().split(" ").map{
        it.toInt()
    }
    val finish_p = reader.readLine().split(" ").map{
        it.toInt()
    }


    reader.close()
    writer.close()
}

/*
* Ввод	Вывод
2 3
4 5
1 1 1 1
3 2 12

1
*
* Пример 2
Ввод	Вывод
2 3
4 5
1 1 1 1
2 2 2

3
* */