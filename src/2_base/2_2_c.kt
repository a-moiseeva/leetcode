package `2_base`

fun main(){
    val n = readln().toInt()
    val a = readln().split(" ").map{it.toInt()}
    var s = mutableSetOf<Int>()
    s.addAll(a.subList(1,a[0]+1))
    repeat(n-1){
        val a = readln().split(" ").map{it.toInt()}
        val k =HashSet<Int>()
        k.addAll(a.subList(1,a[0]+1))
        s = s.intersect(k) as MutableSet<Int>
    }

    println(s.size)
}