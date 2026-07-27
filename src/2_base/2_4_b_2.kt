package `2_base`


fun main() {
    val n = readln().toInt()
    val deque = ArrayDeque<Int>()
    repeat(n) {
        val a = readln().split(" ").map { it.toInt() }
        when (a[0]) {
            1 -> deque.addFirst(a[1])
            2 -> deque.addLast(a[1])
            3 -> if(!deque.isEmpty()) deque.removeFirst()
            4 -> if(!deque.isEmpty()) deque.removeLast()
        }
        if(deque.isEmpty()) println(-1)
        else println("${deque.first()} ${deque.last()}")
        //deque.printDeque()

    }

}