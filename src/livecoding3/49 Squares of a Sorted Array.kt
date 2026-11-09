package livecoding3

fun sortedSquares(nums: IntArray): IntArray {
    val result = IntArray(nums.size)

    var left = 0
    var right = nums.lastIndex
    var position = nums.lastIndex

    while (left <= right) {
        val leftSquare = nums[left] * nums[left]
        val rightSquare = nums[right] * nums[right]

        if (leftSquare > rightSquare) {
            result[position] = leftSquare
            left++
        } else {
            result[position] = rightSquare
            right--
        }

        position--
    }

    return result
}
