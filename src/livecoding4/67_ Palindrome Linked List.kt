package livecoding4


class Solution67 {
    fun isPalindrome(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        var prev: ListNode? = null
        while (slow != null) {
            val next = slow.next
            slow.next = prev
            prev = slow
            slow = next
        }
        var start = head
        while (start != null && prev != null) {
            if (start.`val` != prev.`val`) return false
            start = start.next
            prev = prev.next
        }
        return true
    }
}