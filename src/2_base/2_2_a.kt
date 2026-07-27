package `2_base`

fun main(){
    val n = readln().toInt()
    val m = mutableSetOf<Int>()
    for (i in 0 until n){
        val (a,b) =readln().split(" ").map{it.toInt()}
        if(a==1){
                m.add(b)
        }
        if (a==2){
            if(m.contains(b)){
                println(1)
            }else{
                println(0)
            }
        }
    }
}