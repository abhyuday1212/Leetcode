/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // OPTIMAL: Modified Tartoise Hare
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null && n == 1){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(n != 0){
            fast = fast.next;
            n--;
        }

        // if n is such that the fast pointer out of index chla jata, to wha pe removal perform ni ho skta
        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // slow is standing at the element before to be deleted
        slow.next = slow.next.next;
        return head;
    }
}