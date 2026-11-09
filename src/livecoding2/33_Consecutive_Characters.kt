package livecoding2

class Solution33 {
    fun maxPower(s: String): Int {
        var max =0
        var left=0
        for (right in 0..s.length-1){
            if(s[right]==s[left]) {
                max= maxOf(max,right-left+1)
            }
            else left=right
        }
        return max

    }
}