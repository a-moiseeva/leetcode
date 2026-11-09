    package livecoding2

    import livecoding1.Solution3

    class Solution24 {
    fun twoSum(nums: IntArray, target: Int): IntArray? {
        val m =mutableMapOf<Int,Int>()
        for (i in nums.indices){
            if (m.contains(target-nums[i])) return intArrayOf(m[target-nums[i]]!!, i)
            m[nums[i]] = i
        }
        return null
    }
}

    class Solution324333 {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            var i =0
            var j = nums.size-1

            while(nums[i]+nums[j]!= target){
                if(nums[i]+nums[j]< target) i++
                else j++
                println(i)
                println(j)

            }
            return intArrayOf(i, j)

            }

    }
    fun main(){
        val solution = Solution324333().twoSum(intArrayOf(2,7,11,15), 9)
    }