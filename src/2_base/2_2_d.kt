package `2_base`

fun main(){
    val n = readln().toInt()
    val allsetssizes = mutableListOf<Int>()
    val a0 = readln().split(" ").map{it.toInt()}
    val b0= a0.subList(1, a0[0]+1).toSet()
    allsetssizes.add(b0.size)

    var intersectionset = b0
    var unionset= b0 as MutableSet<Int>
    var sizeofallelements=b0.size

    repeat(n-1){
        val a = readln().split(" ").map{it.toInt()}
        val b = a.subList(1, a[0]+1).toSet()
        allsetssizes.add(b.size)
        intersectionset=intersectionset.intersect(b)
        unionset.addAll(b)
        sizeofallelements=sizeofallelements+b.size
    }
    if (intersectionset.size==0){
        println("NO")
        return
    }
    val intersectionsize=intersectionset.size
    if (sizeofallelements-intersectionset.size*(n-1)== unionset.size){
        println("YES")
        println("$intersectionsize")
        for (i in 0 until n){
            print("${allsetssizes[i]-intersectionsize} ")
        }

        return
    }
    println("NO")


}