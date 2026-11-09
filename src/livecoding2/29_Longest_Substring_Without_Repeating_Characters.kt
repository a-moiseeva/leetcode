package livecoding2

class SolutionGood {
    fun lengthOfLongestSubstring(s: String): Int {
        val need = IntArray(128){0}
        var left=0
        var matched=0
        var max=0
        for (right in 0..s.length-1){
            val letter = s[right].code
            if(need[letter]==0) {need[letter]++; matched++}
            else {
                while (s[left].code != letter){
                    need[s[left].code ]--
                    matched--
                    left++
                }
                left++
            }
            max=maxOf(max,matched)
        }
        return max
    }
}



class Solution29 {
    fun lengthOfLongestSubstring(s: String): Int {
        val need = IntArray(26){0}
        var left=0
        var matched=0
        var max=0
        for (right in 0..s.length-1){
            val letter = s[right].code-'a'.code
            if(need[letter]==0) {need[letter]++; matched++}
            else {
                while (s[left].code-'a'.code != letter){
                    need[s[left].code - 'a'.code]--
                    matched--
                    left++
                }
                left++
            }
            max=maxOf(max,matched)
        }
        return max
    }
}

class Solutiondsd {
    fun lengthOfLongestSubstring(s: String): Int {
        val m = HashMap<Char,Int>()
        var max = 0
        var cur = 0
        var left=0
        for(right in 0..s.length-1){
            val letter=s[right]
            val number = m.getOrDefault(letter,0)+1
            if(number!=1){
                while(s[left]!=letter) left++
                left++
            }
            m[letter]=1
            max = maxOf(max, right-left+1)
        }
        return max


    }
}

class Solution29b {
    fun lengthOfLongestSubstring(s: String): Int {
        val lastIndex = HashMap<Char,Int>()
        var left=0
        var max=0
        for (right in 0..s.length-1){
            val letter = s[right]
            if(lastIndex.containsKey(letter)&&left<=lastIndex[letter]!!){
                left=lastIndex[letter]!!+1
            }
            lastIndex[letter]=right
            max=maxOf(max,right-left+1)
        }
        return max
    }
}
fun main(){
    Solution29().lengthOfLongestSubstring("abcdefg").let{println(it)}
}