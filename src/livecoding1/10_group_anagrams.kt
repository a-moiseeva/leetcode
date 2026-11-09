package livecoding1


class Solution10 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var m = HashMap<String, MutableList<String>>()
        for (str in strs) {
            val key = str.toCharArray().sortedArray().concatToString()
            val v = m[key] ?: mutableListOf()
            v.add(str)
            m[key] = v
        }
        val answer= mutableListOf<List<String>>()
        for (x in m){
            answer.add(x.value)
        }
        return answer
    }
}
fun main(){
    Solution10().groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
}