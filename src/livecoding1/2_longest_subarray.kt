package livecoding1

class Solution2 {
    fun longestSubarray(nums: IntArray): Int {
        val n = nums.size
        var zerocount = 0
        var max_sum = -1
        var left = 0

        for (right in 0..n - 1) {
            if (nums[right] == 0) zerocount++
            while (zerocount > 1) {
                if (nums[left] == 0) zerocount--
                left++
            }
            max_sum = Math.max(max_sum, right - left)
        }

        return max_sum

    }
}

class SolutionZ {
    fun longestSubarray(nums: IntArray): Int {
        var left = -1
        var longest = 0
        var zeros = 0
        for (right in 0..nums.size-1) {
            if (nums[right] == 0) zeros++
            while (zeros > 1 && left < right) {
                left++
                if (nums[left] == 0) zeros--
            }
            if (right - left > longest) longest = right - left -1
        }
        return longest
    }
}

fun main() {
    println(SolutionZ().longestSubarray(intArrayOf(1, 1, 0, 1)))
    println(SolutionZ().longestSubarray(intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)))
    println(SolutionZ().longestSubarray(intArrayOf(1, 1, 1)))
    println(SolutionZ().longestSubarray(intArrayOf(0, 1, 1, 1, 0, 0, 1, 1, 0, 1)))
}