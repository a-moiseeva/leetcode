package livecoding2

import javax.sound.midi.spi.SoundbankReader

class Solution26 {
    fun findAnagrams(s: String, p: String): List<Int> {
        var answer = mutableListOf<Int>()
        if (s.length < p.length) return answer
        val need = IntArray(26) { 0 }
        for (i in p) {
            need[i.code - 'a'.code]++
        }
        val window = IntArray(26) { 0 }

        var matched = 0
        val required = need.count { it > 0 }

        var left = 0

        for (right in s.indices) {
            val letter = s[right]
            window[letter.code - 'a'.code]++
            if (need[letter.code - 'a'.code] != 0 &&
                need[letter.code - 'a'.code] == window[letter.code - 'a'.code]) {
                matched++
            }
            if (right - left + 1 > p.length) {
                val letdel = s[left]
                if (need[letdel.code - 'a'.code] != 0 &&
                    need[letdel.code - 'a'.code] == window[letdel.code - 'a'.code]) {
                    matched--
                }
                window[letdel.code - 'a'.code]--
                left++
            }
            if (matched == required) answer.add(left)
        }
        return answer
    }
}
fun main(){
    println(Solution26().findAnagrams("cbaebabacd", "abc").joinToString(""))
}