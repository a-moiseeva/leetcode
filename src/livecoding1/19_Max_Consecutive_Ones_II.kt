package livecoding1

fun main(){
    val nums = readln().split(",").map{it.toInt()}

    var max_sum=0
    var left=0
    var zeros=0

    for(right in nums.indices){
        if(nums[right]==0){
            zeros++
            while(zeros>1){
                if(nums[left]==0){ zeros--}
                left++
            }
        }
        if(right-left+1>max_sum) max_sum=right-left+1
    }
    println(max_sum)

}