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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode tail = head;

        int len = 1;
        while(tail.next != null){
            tail = tail.next;
            len += 1;
        }

        if(k > len) k = k%len;

        if(k == len || k == 0) return head;

        //Now the tail is standing at the last Node and every thing you have to do is between 1-4

        ListNode temp = head;

        int idx = 1;
        int target = len - k;

        if(target == 0) {
            target = 1;
        }

        while(idx != target && temp.next != null){
            temp = temp.next;
            idx++;
        }

        ListNode front = temp.next;
        temp.next = null;
        tail.next = head;

        return front;
    }
}