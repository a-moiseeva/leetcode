package livecoding1

class LRUCache(capacity: Int) {
    class Node(){
        var value=0
        var next : Node? = null
        var prev: Node? = null
        var key=0
    }
    val n = capacity
    var head = Node()
    var tail = Node()
    init{
        head.next=tail
        tail.prev= head
    }
    val cache = HashMap<Int,Node>()

    fun get(key: Int): Int {
        val node = cache[key] ?: return -1

        //delete node:
        val prev = node.prev!!
        val next = node.next!!
        prev.next=next
        next.prev=prev

        //insert node at the beginning:
        val first= head.next!!
        first.prev=node
        node.next=first!!
        head.next=node
        node.prev=head

        return node.value
    }

    fun put(key: Int, value: Int) {

        if (cache.contains(key)){
            val node = cache[key]!!
            node.value=value
            node.key=key

            //delete node:
            val prev = node.prev!!
            val next = node.next!!
            prev.next=next
            next.prev=prev

            //insert node at the beginning:
            val first= head.next!!
            first.prev=node
            node.next=first
            head.next=node
            node.prev=head

            return

        }
        val node=Node()
        node.key=key
        node.value = value
        cache[key]=node

        //insert node at the beginning:
        val first= head.next!!
        first.prev=node
        node.next=first
        head.next=node
        node.prev=head

        if (cache.size>n){
            val nodedelete=tail.prev!!
            val prev = nodedelete.prev!!
            val next = nodedelete.next!!
            prev.next=next
            next.prev=prev
            cache.remove(nodedelete.key)
        }
    }
}
