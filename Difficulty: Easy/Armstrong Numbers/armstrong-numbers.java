// User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        int originalNum = n;
        int sum = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            sum = sum + lastDigit * lastDigit * lastDigit;
            n = n / 10;
        }

        if (sum == originalNum) {
            return true;
        }  
        
        return false;
     
    }
}