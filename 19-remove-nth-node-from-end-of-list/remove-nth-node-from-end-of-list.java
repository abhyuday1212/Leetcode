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
    // Modified Version of tartoise and hare which take the 
    // Tc: O(n)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;

        if (head.next == null && n == 1) {
            return null;
        }

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode slow = head;

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    // Brut is find the length of the LL and subtract the n, and traverse the LL
    // Tc: O(2n) {In worst case...}
    // till that ans
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    // ListNode temp = head;

    // int lengthOfLL = findLength(head);

    // if(lengthOfLL == 1 && n == 1){
    // return null;
    // }

    // int count = lengthOfLL - n;
    // if (count < 0) {
    // return head;
    // }
    // else if(count == 0){
    // return head = head.next;
    // }

    // while (count != 1) {
    // count--;
    // temp = temp.next;
    // }

    // temp.next = temp.next.next;

    // return head;
    // }

    // public int findLength(ListNode head) {
    // int count = 0;

    // ListNode temp = head;
    // while (temp != null) {
    // count++;
    // temp = temp.next;
    // }

    // return count;
    // }
}