package livecoding4

class Solution71 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val count = IntArray(26){0}

        for (i in s.indices) {
            count[s[i].code - 'a'.code]=(count[s[i].code-'a'.code] ?: 0)+1
            count[t[i].code-'a'.code]=(count[t[i].code-'a'.code] ?: 0)-1
        }
        for(i in count){
            if(i!=0)return false
        }
        return true
    }
}
