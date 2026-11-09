package livecoding4

class Solution68 {
    fun firstUniqChar(s: String): Int {
        val arr = IntArray(26)
        for ( i in 0..s.length-1){
            val letter = s[i].code-'a'.code
            arr[letter]++
        }
        for ( i in 0..s.length-1){
            val letter = s[i].code-'a'.code
            if(arr[letter]==1) return i
        }
        return -1


    }
}