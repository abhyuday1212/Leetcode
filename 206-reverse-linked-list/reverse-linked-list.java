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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode temp = head;
        ListNode last = null;
        ListNode front = head.next;

        while (temp.next != null) {
            front = temp.next; //temporary variable
            temp.next = last; //linking between the nodes

            last = temp; // for iteration and value modification
            temp = front; // for iteration of the front
        }

        temp.next = last;

        head = temp;

        return head;
    }
}