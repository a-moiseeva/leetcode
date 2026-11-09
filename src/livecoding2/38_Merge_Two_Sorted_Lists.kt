package livecoding2

class Solution37 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }
        if (list1.`val` > list2.`val`) {
            list2.next = mergeTwoLists(list1, list2.next)
            return list2
        } else {
            list1.next = mergeTwoLists(list1.next, list2)
            return list1
        }
    }
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var cur = dummy
        var u1 = list1
        var u2 = list2
        while (u1 != null && u2 != null) {
            if (u1.`val` < u2.`val`) {
                val v = ListNode(u1.`val`)
                cur.next = v
                cur = v
                u1 = u1.next
            } else {
                val v = ListNode(u2.`val`)
                cur.next = v
                cur = v
                u2 = u2.next
            }
        }
        while (u1 != null) {
            val v = ListNode(u1.`val`)
            cur.next = v
            cur = v
            u1 = u1.next
        }
        while (u2 != null) {
            val v = ListNode(u2.`val`)
            cur.next = v
            cur = v
            u2 = u2.next
        }
        return dummy.next
    }
}