package livecoding2
class Solution40 {
    fun longestPalindrome(s: String): String {
        if (s.length < 2) return s

        var start = 0
        var maxLength = 0

        for (i in s.indices) {
            val len1 = expandAroundCenter(s, i, i)
            val len2 = expandAroundCenter(s, i, i + 1)
            val len = maxOf(len1, len2)
            if (len > maxLength) {
                maxLength = len
                start = i - (len - 1) / 2
            }
        }

        return s.substring(start, start + maxLength)
    }

    private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        return r - l - 1
    }
}