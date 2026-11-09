package livecoding4

class Solution69 {
    fun isIsomorphic(s: String, t: String): Boolean {
        if(s.length!=t.length) return false
        val mapS=IntArray(200){-1}
        val mapT=IntArray(200){-1}
        for (i in 0..s.length-1){
            if (mapS[s[i].code]!=mapT[t[i].code]) return false
            mapS[s[i].code]=i
            mapT[t[i].code]=i
        }
        return true
    }
}