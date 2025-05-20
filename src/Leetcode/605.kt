package Leetcode

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    if(n == 0) return true
    if(flowerbed.size <= 2) return false
    var counter = 0
    if(flowerbed[0] == 0 && flowerbed[0] == 0){
        flowerbed[0] = 1
        counter++
    }
    if(flowerbed[flowerbed.size - 1] == 0 && flowerbed[flowerbed.size - 2] == 0){
        flowerbed[flowerbed.size - 1] = 1
        counter++
    }
    for(i in 1..< flowerbed.size - 1){
        if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0 && flowerbed[i] == 0) {
            counter++
            flowerbed[i] = 1
        }
    }
    return counter >= n
}
