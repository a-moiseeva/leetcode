package `5_graph`

import java.util.*

fun minOperations(X:Int,Y:Int):Int{

    val queue:Queue<Pair<Int,Int>> = LinkedList()
    val visited = mutableSetOf<Int>()
    queue.add(Pair(X,0))
    visited.add(X)

    while (queue.isNotEmpty()) {
        val (current, steps) = queue.poll()

        for (c in 0..9) {
            val add = current + c
            val subtract = current - c
            val multiply = current * c
            if((add==Y)or (subtract == Y) or (multiply == Y)) return steps+1

            if (!visited.contains(add)) {
                visited.add(add)
                queue.add(Pair(add,steps+1))
            }
            if (subtract !in visited) {
                visited.add(subtract)
                queue.add(Pair(subtract, steps + 1))
            }
            if (multiply !in visited) {
                visited.add(multiply)
                queue.add(Pair(multiply, steps + 1))
            }
        }
    }
    return -1
}

fun main() {
    val (x,y) = readln().split(" ").map{it.toInt()}
    val result = minOperations(x, y)
    println(result)
}
