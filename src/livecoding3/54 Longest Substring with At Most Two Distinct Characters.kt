package livecoding3

fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
    val count = mutableMapOf<Char, Int>()
    var left = 0
    var answer = 0
    for (right in s.indices) {
        val ch = s[right]
        count[ch] = (count[ch] ?: 0) + 1

        while (count.size > 2) {
            val leftChar = s[left]
            count[leftChar] = count[leftChar]!! - 1

            if (count[leftChar] == 0) {
                count.remove(leftChar)
            }

            left++
        }
        answer = maxOf(answer, right - left + 1)
    }

    return answer
}

fun main(){
    println("ho")
    val result = CharArray(8 + 1)
}