package `9binarysearch`
fun main(){
    val n = readln().toInt()
    val nums = readln().split(" ").map{it -> it.toInt()}
    val value= readln().toInt()
    fun BS(leftIndex:Int, rightIndex:Int, value:Int ):Int {
        if (leftIndex > rightIndex) return -1
        val med = (leftIndex+ rightIndex)/2
        if (nums[med]==value) return med
        if (nums[med]>value) return BS(leftIndex,med-1,value)
        if(nums[med]<value) return BS(med+1,rightIndex,value)
        return -1
    }
    println(BS(0,n-1,value))
}