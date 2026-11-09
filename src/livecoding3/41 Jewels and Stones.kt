package livecoding3

class Solution41 {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val hs = BooleanArray(128)
        for (i in jewels) hs[i.code]=true
        var x = 0
        for(i in stones) {if (hs[i.code]) x++  }
        return x

    }
}