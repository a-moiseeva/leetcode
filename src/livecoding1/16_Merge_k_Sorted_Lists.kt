package livecoding1

import java.util.PriorityQueue

class ListNode16(var `val`: Int) {
    var next: ListNode16? = null
}

class Solution16 {
    fun mergeKLists(lists: Array<ListNode16?>): ListNode16? {
        val pQ = PriorityQueue<ListNode16> { a,b -> a.`val`.compareTo(b.`val`)        }
 /*       val pQ = PriorityQueue<ListNode> { a, b ->
            compareValues(a.`val`, b.`val`)
        }   */

        // Добавляем первые узлы всех непустых списков
        for (head in lists) {
            if (head != null) {
                pQ.offer(head)
            }
        }

        val dummy = ListNode16(0)
        var current = dummy

        while (pQ.isNotEmpty()) {
            val node = pQ.poll()

            current.next = node
            current = node

            // Следующий элемент того же списка
            if (node.next != null) {
                pQ.offer(node.next)
            }
        }

        return dummy.next
    }
}
