package livecoding2

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution36 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var ll1:ListNode?=l1
        var ll2:ListNode?=l2
        val dummy = ListNode(0)
        var current: ListNode? = dummy
        var add = 0
        while (ll1 != null || ll2 != null || add!=0) {
            var x = add
            if (ll1 != null) x = x + ll1.`val`
            if (ll2 != null) x = x + ll2.`val`

            add=x/10

            current!!.next = ListNode(x%10)
            current = current.next!!

            ll1= ll1?.next
            ll2=ll2?.next
        }
        return dummy.next
    }
}