package livecoding3

class Solution46 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // Бинарный поиск выполняем по меньшему массиву
        if (nums1.size > nums2.size) {
            return findMedianSortedArrays(nums2, nums1)
        }
        val m = nums1.size
        val n = nums2.size

        var left = 0
        var right = m

        val leftPartSize = (m + n + 1) / 2

        while (left <= right) {
            val partition1 = (left + right) / 2
            val partition2 = leftPartSize - partition1

            val maxLeft1 =
                if (partition1 == 0) Int.MIN_VALUE
                else nums1[partition1 - 1]

            val minRight1 =
                if (partition1 == m) Int.MAX_VALUE
                else nums1[partition1]

            val maxLeft2 =
                if (partition2 == 0) Int.MIN_VALUE
                else nums2[partition2 - 1]

            val minRight2 =
                if (partition2 == n) Int.MAX_VALUE
                else nums2[partition2]

            when {
                maxLeft1 > minRight2 -> {
                    // Слишком много элементов взяли из nums1
                    right = partition1 - 1
                }

                maxLeft2 > minRight1 -> {
                    // Слишком мало элементов взяли из nums1
                    left = partition1 + 1
                }

                else -> {
                    // Найдено корректное разделение
                    val maxLeft = maxOf(maxLeft1, maxLeft2)

                    if ((m + n) % 2 == 1) {
                        return maxLeft.toDouble()
                    }

                    val minRight = minOf(minRight1, minRight2)

                    return (maxLeft.toLong() + minRight.toLong()) / 2.0
                }
            }
        }

        error("Input arrays are not sorted")
    }
}
