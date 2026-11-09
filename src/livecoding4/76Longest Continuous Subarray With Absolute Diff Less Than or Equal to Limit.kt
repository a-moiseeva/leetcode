package livecoding4

import java.util.ArrayDeque
import kotlin.math.max



fun longestSubarray(nums: IntArray, limit: Int): Int {
    val maxDeque = ArrayDeque<Int>()
    val minDeque = ArrayDeque<Int>()

    var left = 0
    var answer = 0

    for (right in nums.indices) {
        // Поддерживаем очередь максимума
        while (!maxDeque.isEmpty() &&
            nums[maxDeque.peekLast()] <= nums[right]
        ) {
            maxDeque.removeLast()
        }
        maxDeque.addLast(right)

        // Поддерживаем очередь минимума
        while (!minDeque.isEmpty() &&
            nums[minDeque.peekLast()] >= nums[right]
        ) {
            minDeque.removeLast()
        }
        minDeque.addLast(right)

        // Сдвигаем левую границу, пока окно некорректно
        while (
            nums[maxDeque.peekFirst()].toLong() -
            nums[minDeque.peekFirst()].toLong() > limit.toLong()
        ) {
            if (maxDeque.peekFirst() == left) {
                maxDeque.removeFirst()
            }

            if (minDeque.peekFirst() == left) {
                minDeque.removeFirst()
            }

            left++
        }

        answer = max(answer, right - left + 1)
    }

    return answer
}
