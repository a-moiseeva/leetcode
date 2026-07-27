package `2_base`


class Node(val value: Int, var next: Node? = null, var prev: Node? = null) {}

class Deque() {


    var head: Node? = null
    var tail: Node? = null

    fun push_start(value: Int) {

        val newNode = Node(value)
        if (head != null) {
            head!!.next = newNode
            newNode.prev = head
            head = newNode
        }
        if (head == null) {
            head = newNode
            tail = newNode
        }
    }

    fun push_end(value: Int) {
        if (head == null) {
            push_start(value)
            return
        }
        val newNode = Node(value)
        tail!!.prev = newNode
        newNode.next = tail
        tail = newNode
    }

    fun pop_start() {
        if (head == null) {
            return
        }
        if (head === tail) {
            head = null
            tail = null
            return
        }
        head = head!!.prev
    }

    fun pop_end() {
        if (head == null) {
            return
        }
        if (head === tail) {
            head = null
            tail = null
            return
        }
        tail = tail!!.next
    }

    fun printDeque() {
        var a = head
        while (a != null) {
            print(" ${a.value}")
            a = a.prev
        }
        println(" ")
    }

    fun print_last_and_first() {
        if (head == null) println(-1)
        else println("${head!!.value} ${tail!!.value}")
    }

}

fun main() {
    val n = readln().toInt()
    val deque = Deque()
    repeat(n) {
        val a = readln().split(" ").map { it.toInt() }
        when (a[0]) {
            1 -> deque.push_start(a[1])
            2 -> deque.push_end(a[1])
            3 -> deque.pop_start()
            4 -> deque.pop_end()
        }
        deque.print_last_and_first()
        //deque.printDeque()

    }

}