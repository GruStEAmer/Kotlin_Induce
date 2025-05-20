package Leetcode

enum class nav {
    LEFT,
    RIGHT,
    TOP,
    BOTTOM
}

fun main(){
    val a = generateMatrix(3)
    for(i in a){
        for(j in i){
            print("$j ")
        }
        println()
    }
}

fun generateMatrix(n: Int): Array<IntArray> {
    if(n == 1){
        val a = Array<IntArray>(1) { intArrayOf(1) }
        return a
    }
    if(n == 2){
        val a =  Array<IntArray>(2){
            intArrayOf(1,2)
        }
        a[1][0] = 4
        a[1][1] = 3
        return a
    }
    val a:Array<IntArray> = Array<IntArray>(n) {
        IntArray(n) { 0 }
    }
    var turtle = Array(2) {0}
    var counter = 1
    var navigation = nav.RIGHT
    while(counter <= n * n){
        if(navigation == nav.RIGHT){
            if(counter >= n * n) break
            while(turtle[1] < n - 1){
                a[turtle[0]][turtle[1]] = counter
                counter++
                turtle[1]++
                if(a[turtle[0]][turtle[1]] != 0) {
                    counter--
                    turtle[1]--
                    break
                }
            }
            navigation = nav.BOTTOM
        }
        if(navigation == nav.BOTTOM){
            if(counter >= n * n) break
            while(turtle[0] < n - 1){

                a[turtle[0]][turtle[1]] = counter
                counter++
                turtle[0]++
                if(a[turtle[0]][turtle[1]] != 0) {
                    counter--
                    turtle[0]--
                    break
                }
            }
            navigation = nav.LEFT
        }
        if(navigation == nav.LEFT){
            if(counter >= n * n) break
            while(turtle[1] > 0){

                a[turtle[0]][turtle[1]] = counter
                counter++
                turtle[1]--
                if(a[turtle[0]][turtle[1]] != 0) {
                    counter--
                    turtle[1]++
                    break
                }
            }
            navigation = nav.TOP
        }
        if(navigation == nav.TOP){
            if(counter >= n * n) break
            while(turtle[0] >= 0){

                a[turtle[0]][turtle[1]] = counter
                counter++
                turtle[0]--
                if(a[turtle[0]][turtle[1]] != 0) {
                    counter--
                    turtle[0]++
                    break
                }
            }
            navigation = nav.RIGHT
        }
    }

    return a
}