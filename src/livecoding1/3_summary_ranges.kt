package livecoding1

class Solution3 {
    fun summaryRanges(nums: IntArray): List<String> {
        val answer = mutableListOf<String>()
        var left = 0
        if (nums.size==1){
            answer.add("${nums[0]}")
            return answer
        }

        for(right in 1..nums.size-1){
            if(nums[right]!=nums[left]+ right-left){
                if(right-1==left)answer.add("${nums[left]}")
                else answer.add("${nums[left]}->${nums[right-1]}")
                left=right
            }
            if(right==nums.size-1){
                if(right==left)answer.add("${nums[left]}")
                else answer.add("${nums[left]}->${nums[right]}")
            }

        }
        return answer

    }
}
class SolutionW {
    fun summaryRanges(nums: IntArray): List<String> {

        var m = mutableListOf<String>()
        if (nums.size==0 ) return m
        if( nums.size==1)  {m.add("${nums[0]}") ; return m}
        var left =0
        for (right in 1..nums.size-1){
            if(nums[right]!=nums[left]+right-left){
                if(right==left+1) {m.add("${nums[left]}") ; left = right}
                else {m.add("${nums[left]}->${nums[right-1]}"); left=right}

            }
        }
        val right = nums.size-1
        if(right==left) {m.add("${nums[left]}") }
        else {m.add("${nums[left]}->${nums[right]}")}
        return m

    }
}