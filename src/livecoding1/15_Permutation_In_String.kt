package livecoding1

class Solution15gpt {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val need = IntArray(26)
        val window = IntArray(26)
        for (ch in s1) {
            need[ch - 'a']++
        }
        var matched = 0
        val required = need.count { it > 0 }

        var left = 0

        for (right in s2.indices) {
            val rightIndex = s2[right] - 'a'
            window[rightIndex]++

            // Частота символа только что стала нужной
            if (need[rightIndex] > 0 &&
                window[rightIndex] == need[rightIndex]
            ) {
                matched++
            }
            // Размер окна должен быть равен длине s1
            if (right - left + 1 > s1.length) {
                val leftIndex = s2[left] - 'a'
                // Перед удалением частота совпадала,
                // после удаления перестанет совпадать
                if (need[leftIndex] > 0 &&
                    window[leftIndex] == need[leftIndex]
                ) {
                    matched--
                }

                window[leftIndex]--
                left++
            }

            // В окне находятся те же символы, что и в s1
            if (matched == required) {
                return true
            }
        }

        return false
    }
}