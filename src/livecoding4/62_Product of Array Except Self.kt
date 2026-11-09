package livecoding4

class Solution62 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n=nums.size
        val first = IntArray(n)
        val second = IntArray(n)
        var sum = 1
        for (i in nums.indices){
            sum=sum*nums[i]
            first[i]=sum
        }
        sum = 1
        for (i in nums.indices.reversed()){
            sum=sum*nums[i]
            second[i]=sum
        }
        for (i in nums.indices){
            if(i==0) nums[i]=second[1]
            if(i==n-1) nums[i]=first[i-1]
            nums[i]=second[i+1]*first[i-1]
        }
        return nums
    }
}