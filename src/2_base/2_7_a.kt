package `2_base`

import java.util.PriorityQueue

fun main(){
    val a = PriorityQueue<Int>(compareByDescending { it })
    var size =0
    val n =readLine()!!.toInt()
    repeat(n){
        val s = readln().split(" ").map { it.toInt() }
        if (s[0]==1){
            size++
            a.add(s[1])
            println(a.peek())
        }
        if(s[0]==2){
            if(a.size!=0){
                size--
                a.remove()}
            if(size!=0) println(a.peek())
            else println(-1)
        }
    }
}