package `2_base`
import java.sql.SQLOutput
import java.util.PriorityQueue



fun main() {
    val (n,k)= readln().split(" ").map{it -> it.toInt()}
    var servers = mutableListOf<Int>()
    val packages_time= ArrayList<Int>(n)
    repeat(k){servers.add(0)}
    repeat (n){
        val(arrives_At,duration)= readln().split(" ").map{it -> it.toInt()}
        val finishesAt = Math.max(arrives_At,servers.first())+duration
        packages_time.add(finishesAt)
        servers.removeFirst()
        servers.add(finishesAt)
        servers.sort()
    }

    println(packages_time.joinToString(" "))
}