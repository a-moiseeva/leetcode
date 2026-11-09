package livecoding3

class Solution56 {
    fun search(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size-1
        while(low<=high){
            val mid = (high+low)/2
            if(nums[mid]==target){
                return mid
            }else if(nums[low]<=nums[mid]){
                if(target<nums[mid] && target>=nums[low]){
                    high = mid -1
                }else{
                    low = mid +1
                }
            }else{
                if(target>nums[mid] && target <= nums[high]){
                    low = mid +1
                }else{
                    high = mid -1
                }
            }
        }
        return -1
    }
}