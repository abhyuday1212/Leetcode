/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    // Optimal: tartosie hare
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // check if that node already exist
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // Brute: Use a hashMap to check weather that node exist or not
    // public boolean hasCycle(ListNode head) {
    // if (head == null || head.next == null)
    // return false;

    // HashMap<ListNode, Integer> mp = new HashMap<>();
    // ListNode temp = head;

    // while (temp != null) {
    // // check if that node already exist
    // if (mp.containsKey(temp)) {
    // return true;
    // }

    // // save
    // mp.put(temp, mp.getOrDefault(temp, 0) + 1);

    // temp = temp.next;
    // }

    // return false;
    // }
}