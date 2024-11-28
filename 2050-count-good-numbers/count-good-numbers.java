// digits at even indices-> even
// digits at odd indices -> prime(2,3,5,7)

class Solution {
    public int MOD = 1000000007;

    public int countGoodNumbers(long n) {

        // Calculate the number of even and odd positions in the digit string
        long odd = n / 2;
        long even = (n + 1) / 2;

        // Calculate the total number of good digit strings
        // multiplying 5 by even because there could only be 5 even numbers between 0-9
        // multiplying 4 by odd because there could only be 4 prime numbers between

        return (int) (pow(5, even) * pow(4, odd) % MOD);
    }

    // Fast exponentiation method to calculate (x^n) % MOD efficiently
    public long pow(long x, long n) {

        // Base case for the recursion
        if (n == 0)
            return 1;

        // Recursively calculate x^(n/2)
        long half = pow(x, n / 2);

        // If n is even, return (x^(n/2))^2
        if (n % 2 == 0) {
            return (half * half) % MOD;
        }
        // If n is odd, return (x^(n/2))^2 * x
        else {
            return (x * half * half) % MOD;
        }
    }

// -------------- BrutForce Approach

    // smaller problem -> (digit-> index) (isEven or isOdd)
    // pick the first

    // public int recursivApproach(long n, int index,int ans) {
    // if (index >= n) {
    // // If out of bound
    // return ans;
    // }

    // if (index % 2 == 0) {
    // // index is even
    // ans = ans * 5;
    // ans = helper(n, index + 1,ans);
    // return ans;
    // }
    // else {
    // /// if index is odd

    // // self work
    // // ans = ans*4;

    // // smaller problem
    // ans = ans* 4;
    // ans = helper(n, index + 1,ans);
    // return ans;
    // }
    // }
}