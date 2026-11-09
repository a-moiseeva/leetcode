package livecoding3
import java.util.ArrayDeque
import java.util.TreeMap


class MaxStack {
    private class Node(val value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }
    // Два фиктивных узла для удобной работы со списком
    private val head = Node(0)
    private val tail = Node(0)
    /*
     * Для каждого значения храним узлы в порядке добавления.
     * Последний узел — самый верхний среди узлов с таким значением.
     */
    private val nodesByValue = TreeMap<Int, ArrayDeque<Node>>()

    init {
        head.next = tail
        tail.prev = head
    }

    fun push(x: Int) {
        val node = Node(x)
        // Добавляем узел в конец двусвязного списка
        val last = tail.prev!!
        last.next = node
        node.prev = last
        node.next = tail
        tail.prev = node
        // Добавляем узел в группу соответствующего значения
    /*    if(nodesByValue.containsKey(x)) {  }
        else nodesByValue[x]=ArrayDeque()
        nodesByValue[x]!!.addLast(node)*/
        nodesByValue
            .getOrPut(x) { ArrayDeque() }
            .addLast(node)
    }

    fun pop(): Int {
        val node = tail.prev!!
        removeNode(node)

        val nodes = nodesByValue[node.value]!!
        nodes.removeLast()

        if (nodes.isEmpty()) {
            nodesByValue.remove(node.value)
        }
        return node.value
    }

    fun top(): Int {
        return tail.prev!!.value
    }
    fun peekMax(): Int {
        return nodesByValue.lastKey()
    }
    fun popMax(): Int {
        val maxValue = nodesByValue.lastKey()
        val nodes = nodesByValue[maxValue]!!

        /*
         * Последний узел с этим значением является
         * самым верхним среди одинаковых максимальных элементов.
         */
        val node = nodes.removeLast()
        removeNode(node)

        if (nodes.isEmpty()) {
            nodesByValue.remove(maxValue)
        }

        return maxValue
    }

    private fun removeNode(node: Node) {
        val prev = node.prev!!
        val next = node.next!!

        prev.next = next
        next.prev = prev
    }
}
