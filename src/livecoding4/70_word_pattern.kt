package livecoding4

class Solution70 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val m = mutableMapOf<Char, String>()
        val mr = mutableMapOf<String, Char>()
        val st= s.split(" ")
        if(pattern.length!=st.size) return false
        for(i in st.indices){
            if (m.contains(pattern[i])&&m[pattern[i]]!=st[i]) return false
            if (mr.contains(st[i])&&mr[st[i]]!=pattern[i]) return false
            m[pattern[i]]=st[i]
            mr[st[i]]=pattern[i]
        }
        return true
    }
}