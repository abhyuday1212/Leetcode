class Solution {
    public int reverse(int x) {
        int rev = 0;
        int max_int = Integer.MAX_VALUE; //2147483647;
        int min_int = Integer.MIN_VALUE; //-2147483648;

        while (x != 0) {
            int digit = x % 10;

            // Check for positive overflow conditions
            if (rev > max_int / 10 || (rev == max_int / 10 && digit > 7)) {
                return 0;
            }
            // Check for negative overflow conditions
            if (rev < min_int / 10 || (rev == min_int / 10 && digit < -8)) {
                return 0;
            }

            rev = rev * 10 + digit;
            x /= 10;
        }

        return rev;
    }
}