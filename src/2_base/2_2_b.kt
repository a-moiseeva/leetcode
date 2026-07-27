package `2_base`

fun main(){
    val n = readln().toInt()
    if(n>0){
        var m = HashSet<Int>()
        for(i in 0..n-1){
            val a = readln().split(" ").map{it.toInt()}
            m.addAll(a.subList(1,a[0]+1))
        }
        println(m.size)

    }

}