package livecoding3

class Solution44 {
    fun missingNumber(nums: IntArray): Int {
        val x = IntArray(nums.size)
        for(i in nums){
            x[i]=1
        }
        for(i in x.indices){
            if (x[i]==0)
                return i
        }
        return -1
    }
}

class Solution44l {
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size+1
        val expected = ((0+n)/2)*n
        val now = nums.sum()
        return expected-now
    }
}