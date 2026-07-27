package `2_base`

fun main(){
    val q = mutableListOf<Int>()
    val n = readln().toInt()
    var first =0
    var last=0
    for(i in 1..n){
        val a = readln().split(" ").map{it.toInt()}
        if (a[0]==1) {
            q.add(a[1]).also { last++ }}
        else  first++


        println(if (first==last) -1 else q[first])
    }

}