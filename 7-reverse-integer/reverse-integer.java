class Solution {
    public int reverse(int x) {
        int rev = 0;
        // Integer.MAX_VALUE; //2147483647;
        // Integer.MIN_VALUE; //-2147483648;

        while (x != 0) {
            int digit = x % 10;

            // Check if multiplying rev by 10 would cause overflow/underflow
            // Integer.MAX_VALUE = 2147483647, so MAX_VALUE/10 = 214748364
            // Integer.MIN_VALUE = -2147483648, so MIN_VALUE/10 = -214748364
            // Check for positive overflow conditions
            if (rev > 214748364 || (rev == 214748364 && digit > 7)) {
                return 0;
            }
            // Check for negative overflow conditions
            if (rev < -214748364 || (rev == -214748364 && digit < -8)) {
                return 0;
            }

            rev = rev * 10 + digit;
            x /= 10;
        }

        return rev;
    }
}