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
    // Brut is find the length of the LL and subtract the n, and traverse the LL
    // till that ans
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;

        int lengthOfLL = findLength(head);

        if(lengthOfLL == 1 && n == 1){
            return null;
        }

        int count = lengthOfLL - n;
        if (count < 0) {
            return head;
        }
        else if(count == 0){
            return head = head.next;
        }

        while (count != 1) {
            count--;
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    public int findLength(ListNode head) {
        int count = 0;

        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}