package `2_base`

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }

    var minDiff = Int.MAX_VALUE
    var minPair = Pair(-1, -1)

    var maxDiff = Int.MIN_VALUE
    var maxPair = Pair(-1, -1)

    // Ищем пары для минимальной и максимальной разности
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val diff = a[i] - a[j]

            if (diff < minDiff) {
                minDiff = diff
                minPair = Pair(i + 1, j + 1) // Пара индексов, +1 для соответствия формату
            } else if (diff == minDiff) {
                if (minPair.first > i + 1 || (minPair.first == i + 1 && minPair.second > j + 1)) {
                    minPair = Pair(i + 1, j + 1)
                }
            }

            // Максимальная разность
            if (diff > maxDiff) {
                maxDiff = diff
                maxPair = Pair(i + 1, j + 1) // Пара индексов, +1 для соответствия формату
            } else if (diff == maxDiff) {
                if (maxPair.first > i + 1 || (maxPair.first == i + 1 && maxPair.second > j + 1)) {
                    maxPair = Pair(i + 1, j + 1)
                }
            }
        }
    }

    // Вывод результата
    println("${minPair.first} ${minPair.second}")
    println("${maxPair.first} ${maxPair.second}")
}
