package livecoding1

class Solution6 {
    fun isPalindrome(s: String): Boolean {
        val n = s.length
        var left = 0
        var right = n - 1
        while (left < right) {
            while (!s[left].isLetterOrDigit()) {
                left++
                if (left >= n) return true
            }
            while (!s[right].isLetterOrDigit()) {
                right--
                if (right < 0) return true
            }
            if (s[left].lowercaseChar() != s[right].lowercaseChar()) {
                return false
            }
            left++
            right--
            if (left >= n) return true
            if (right < 0) return true
        }
        return true
    }
}


class SolutionL {
    fun isPalindrome(s: String): Boolean {
        var left = s.length - 1
        var right = 0
        while (left <= right) {
            while (!s[left].isLetter()) {
                left++
                if (left >= s.length) return true
            }
            while (!s[right].isLetter()) {
                right--
                if (right < 0) return true
            }
            if (s[left].lowercaseChar() != s[right].lowercaseChar()) {
                return false
            }
            right--
            left++
        }
        return true
        if (left >= s.length) return true
        if (right < 0) return true

    }
}