package livecoding1

class Solution9 {
    fun moveZeroes(nums: IntArray): Unit {

        var check=0
        val n = nums.size
        for(write in 0..n-1){
            while(check<n&&nums[check]==0 ){
                check++
            }
            if (check<n && nums[check]!=0){
                nums[write]=nums[check]
                check++
            } else nums[write]=0

        }
        return

    }
}