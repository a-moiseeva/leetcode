package `2_base`

fun main(){
    val n = readln().toInt()
    val m = mutableMapOf<Int,Int>()

    repeat(n){
        val a = readln().split(" ").map{it.toInt()}

        if(a[0]==1){
            m[a[1]]=a[2]
        }
        if(a[0]==2){
            println(m.getOrDefault(a[1], -1))
        }
    }
}