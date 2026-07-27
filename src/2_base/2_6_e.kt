package `2_base`

fun maxBalancedSegmentLength(n: Int, types: IntArray): Int {
    val stack = mutableListOf<Int>()
    var maxLength = 0
    var start = 0

    for (i in types.indices) {
        // Если стек пуст или текущий тип отличается от типа на верхушке стека
        if (stack.isEmpty() || (types[i] % 2 != types[stack.last()] % 2)) {
            stack.add(i)
        } else {
            // Найдено несоответствие, обновляем стартовую позицию
            start = stack.removeAt(stack.size - 1) + 1
            stack.add(i)
        }
        println(stack)

        // Проверяем, что последний элемент в стеке четный, и если да, то обновляем максимальную длину
        if (stack.size % 2 == 0) {
            maxLength = maxOf(maxLength, i - start + 1)
        }
    }

    return maxLength
}

fun main() {
    // Чтение входных данных
    val n = readLine()!!.toInt()
    val types = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    // Получение результата
    val result = maxBalancedSegmentLength(n, types)

    // Вывод результата
    println(result)
}
