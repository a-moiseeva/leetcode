package `2_base`

fun main(){
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    var max=0
    var winner=0
    var m = mutableMapOf<Int,Int>()
    for (i in 0 until n){
        val b =a[i]
        val k =m.getOrDefault(b,0)+1
        m[b]=k
        if((k>max) or (k==max && b<winner)){
            max=k
            winner=b
        }
    }
    print(winner)
}