package livecoding1
class Solution8 {
    fun subarraySum(nums: IntArray, k: Int):Int{
        val m = HashMap<Long,Int>()
        var curSum=0L
        var score=0
        m[0]=1

        for (i in 0..nums.size-1){
            curSum=curSum+nums[i]
            if(m.containsKey(curSum-k)){
                score=score+m[curSum-k]!!
            }
            m[curSum]= (m[curSum] ?: 0) +1
        }
        println(m)
        return score
    }
}

fun main(){
    println(Solution8().subarraySum(intArrayOf(1,2,3,-3), 3))
}