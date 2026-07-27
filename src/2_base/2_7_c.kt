package `2_base`

import java.util.PriorityQueue

fun main(){
    val (n,k)= readln().split(" ").map { it.toInt() }
    val s = readln().split(" ").map { it.toInt() }
    val pq= s.sortedDescending()
    println(pq)

    var sum = 0
    repeat(k){
        sum += pq[it]
    }
    println(sum)
}