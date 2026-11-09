package livecoding3
import java.util.ArrayDeque
class Solution55d {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Int>()
        val positions = ArrayDeque<Int>()
        // largest rectangle area
        var max = 0
        for (i in 0 until heights.size) {
            val h = heights[i]
            var from: Int = 0
            if (stack.isEmpty() || h >= stack.last()) {
                from = i
            } else {
                while (stack.isNotEmpty() && h < stack.last()) {
                    val cap = stack.removeLast()
                    from = positions.removeLast()
                    val area = cap * (i - from)
                    max = maxOf(max, area)
                }
            }
            stack.addLast(h)
            positions.addLast(from)
            // println("put on stack: $h with pos $from")
        }
        // println("final stack $stack pos $positions")
        val to = heights.size
        while (stack.isNotEmpty()) {
            val cap = stack.removeLast()
            val from = positions.removeLast()
            val area = cap * (to - from)
            max = maxOf(max, area)
        }

        return max
    }
}