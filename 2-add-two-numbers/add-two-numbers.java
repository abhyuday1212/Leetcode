
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
import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();

        while (l1 != null) {
            list1.add((long) l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            list2.add((long) l2.val);
            l2 = l2.next;
        }

        Collections.reverse(list1);
        Collections.reverse(list2);

        BigInteger list1Digits = findDigitFromList(list1);
        BigInteger list2Digits = findDigitFromList(list2);

        // long sum = list1Digits + list2Digits;
        BigInteger sum = list1Digits.add(list2Digits);

        // if (sum == 0)
        //     return new ListNode(0);
        if (sum.equals(BigInteger.ZERO))
            return new ListNode(0);

        return convertDigitToLL(sum);
    }

    public ListNode convertDigitToLL(BigInteger num) {
        ListNode temp = new ListNode(-1);
        ListNode tempHead = temp;
        while (num.compareTo(BigInteger.ZERO) > 0) {
            // while (num > 0) {
            // long remainder = num % 10; // got the last digit
            // temp.next = new ListNode((int) remainder);

            BigInteger[] divMod = num.divideAndRemainder(BigInteger.TEN);
            temp.next = new ListNode(divMod[1].intValue());

            // num = num / 10;
            num = divMod[0];
            temp = temp.next;
        }

        return tempHead.next;
    }

    public BigInteger findDigitFromList(List<Long> temp) {
        BigInteger digit = BigInteger.ZERO;

        for (Long num : temp) {
            // digit = digit * 10 + num;
            digit = digit.multiply(BigInteger.TEN).add(BigInteger.valueOf(num));
        }

        return digit;
    }
}