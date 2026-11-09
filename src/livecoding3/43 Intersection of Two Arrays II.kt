package livecoding3

class Solution43 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val hm = IntArray(1001)
        for (i in nums1){
            hm[i]=hm[i]+1
        }
        val ans = IntArray(nums1.size)
        var j=0
        for(i in nums2){
            if(hm[i]==0) continue
            ans[j]=i
            j++
            hm[i]=hm[i]-1
        }
        return ans.copyOf(j)

    }
}