package `2_base`

import java.util.PriorityQueue
data class Ticket(val time:Int, val weight: Int)
fun main(){
    val n =readln().toInt()
    val pq= PriorityQueue<Ticket>(compareByDescending<Ticket> { it.weight }.thenBy { it.time })
    repeat(n) {
        val(time,weight)=readln().split(" ").map{it.toInt()}
        pq.add(Ticket(time,weight))
    }
    var first =0
    var second = 0
    repeat(n){
        val(time,weight)=pq.poll()
        if(first<=second){
            first=first+time
        }else second=second+time
    }
    println(Math.max(second,first))
}
