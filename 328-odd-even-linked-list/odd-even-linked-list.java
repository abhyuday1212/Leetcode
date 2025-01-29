/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    //Brut:
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while ( even != null && even.next != null) {
//            prev = odd;
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next; //iteration
            even = even.next; //iteration
        }

        odd.next = evenHead;
        return head;
    }
}