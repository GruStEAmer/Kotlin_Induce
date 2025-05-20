package TBank.`2025`

fun main() {
    val n = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    var count = 0

    for (l in 0 until n) {
        for (r in l + 2 until n) {
            // Проверяем, есть ли в подмассиве array[l..r] хотя бы одна тройка AP
            var found = false
            for (i in l until r) {
                for (j in i + 1 until r) {
                    for (k in j + 1..r) {
                        if (array[j] - array[i] == array[k] - array[j]) {
                            found = true
                            break
                        }
                    }
                    if (found) break
                }
                if (found) break
            }
            if (found) count++
        }
    }

    println(count)
}