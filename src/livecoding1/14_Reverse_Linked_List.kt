package livecoding1

class ListNode(
    var `val`: Int = 0,
    var next: ListNode? = null
)

class Solution14 {
    fun reverseList(head: ListNode?): ListNode? {

        if( head ==null || head.next==null ){
            return head
        }
        val newh = reverseList(head.next)!!
        head.next!!.next=head!!
        head.next=null
        return newh
    }
}

class Solution14n    {
    fun reverseList(head: ListNode?): ListNode? {
        var current = head
        var prev: ListNode?=null
        while (current!=null){
            val temp = current.next
            current.next = prev
            prev = current
            current = temp
        }
        return current
    }
}
