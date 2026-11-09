package livecoding3

class Solution57 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.lastIndex

        while (left < right) {
            val sum = numbers[left] + numbers[right]

            when {
                sum == target -> {
                    // Индексы должны быть 1-индексированными
                    return intArrayOf(left + 1, right + 1)
                }

                sum < target -> {
                    left++
                }

                else -> {
                    right--
                }
            }
        }

        return intArrayOf()
    }
}
