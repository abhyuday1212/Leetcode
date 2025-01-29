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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        //find middle element
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp1 = head;
        ListNode temp2 = reverseLL(slow, null);

        while (temp1 != null && temp2 != null) {
            if (temp1.val != temp2.val) {
                return false;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    // optimal Approach: Recursive Approach
    public ListNode reverseLL(ListNode temp, ListNode last) {
        if (temp.next == null) {
            temp.next = last;
            return temp;
        }

        ListNode front = temp.next;
        temp.next = last;
        return reverseLL(front, temp);
    }
}