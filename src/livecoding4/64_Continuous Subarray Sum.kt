package livecoding4

class Solution64 {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val map = hashMapOf<Int, Int>()
        map[0] = -1
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            val rem = sum % k
            if (map.containsKey(rem)) {
                if (i - map[rem]!! >= 2) return true
            } else {
                map[rem] = i
            }
        }
        return false
    }
}