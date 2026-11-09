package livecoding3





fun maximalRectangle(matrix: Array<CharArray>): Int {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return 0

    val rows = matrix.size
    val cols = matrix[0].size
    val heights = IntArray(cols)
    var maxArea = 0

    for (row in 0 until rows) {
        for (col in 0 until cols) {
            heights[col] = if (matrix[row][col] == '1') {
                heights[col] + 1
            } else {
                0
            }
        }

        maxArea = maxOf(maxArea, largestRectangleArea(heights))
    }

    return maxArea
}

private fun largestRectangleArea(heights: IntArray): Int {
    val stack = IntArray(heights.size + 1)
    var stackSize = 0
    var maxArea = 0

    for (i in 0..heights.size) {
        val currentHeight = if (i == heights.size) 0 else heights[i]

        while (
            stackSize > 0 &&
            heights[stack[stackSize - 1]] > currentHeight
        ) {
            val height = heights[stack[--stackSize]]

            val leftBoundary = if (stackSize == 0) {
                -1
            } else {
                stack[stackSize - 1]
            }

            val width = i - leftBoundary - 1
            maxArea = maxOf(maxArea, height * width)
        }

        if (i < heights.size) {
            stack[stackSize++] = i
        }
    }

    return maxArea
}
