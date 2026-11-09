package livecoding4

import java.util.PriorityQueue
import kotlin.random.Random
class RandomizedSet() {
    val m = mutableMapOf<Int,Int>()
    val arr = ArrayDeque<Int>()

    fun insert(`val`: Int): Boolean {
        if (m.contains(`val`)) return false
        m[`val`]=arr.size
        arr.addLast(`val`)
        return true
    }
    fun remove(`val`: Int): Boolean {
        if(!m.contains(`val`)) return false
        val key = m[`val`]!!
        m.remove(`val`)
        arr[key]=arr.last()
        arr.removeLast()
        return true
    }

    fun getRandom(): Int {
        val n = Random.nextInt(arr.size)
        return arr[n]
    }

}

class LRUCache(capacity: Int) {
    class Node(val key: Int){
        val value: Int? = 0
        var next: Node? = null
        var prev: Node? = null
    }
    val m = HashMap<Int,Node>()
    var tail= Node(0)
    var head = Node(0)
    var curNumb =0
    init{
        head.next = tail
        tail.prev = head
    }
    fun get(key: Int): Int {
        if (!m.contains(key)) return -1
        val answ = m[key]!!.value!!
        val theNode = m[key]!!
        m[key]!!.prev!!.next = m[key]!!.next
        m[key]!!.next!!.prev = m[key]!!.prev
        val firstNode = head.next!!
        head.next = theNode
        theNode.prev = head
        theNode.next = firstNode
        firstNode.prev = theNode
        return answ
    }

    fun put(key: Int, value: Int) {

    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null

}
class Solution54353 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pQ = PriorityQueue<ListNode>{ a, b -> a.`val`-b.`val`}
        val dummy = ListNode(0)
        for (i in lists){
            if(i!= null) pQ.offer(i)
        }
        var curr = dummy
        while(pQ.isNotEmpty()){
            curr.next = pQ.poll()
            val curr = curr.next
            if(curr!= null) pQ.offer(curr.next)
        }
        return dummy.next
    }
}

