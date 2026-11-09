package livecoding4


class Solution61 {
    fun partitionLabels(s: String): List<Int> {
        val lastOccurrence = mutableMapOf<Char, Int>()
        for (i in s.indices) {
            lastOccurrence[s[i]] = i
        }
        val result = mutableListOf<Int>()
        var start = 0
        var end = 0

        for (i in s.indices) {
            end = maxOf(end, lastOccurrence[s[i]]!!)
            if (i == end) {
                result.add(end - start + 1)
                start = i + 1
            }
        }

        return result
    }
}