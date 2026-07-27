package `2_base`

fun main(){
    val n = readln().toInt()
    val a = readln().split(" ").map{it -> it.toInt()}
    var max = a[0]
    var pos = 0
    for (i in 1..n-1){
        if (a[i]>=max){
            max = a[i]
            pos=i
        }
    }
    print(a.subList(0, pos).joinToString(" "))
    print(" ")
    print(a.subList(pos+1, a.size).joinToString(" "))

}