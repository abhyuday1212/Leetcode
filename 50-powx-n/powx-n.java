// we need to find the mathematical function that is required to find the power
// once we found out the method then we need to just call recursion, to carry out the same overation multiple times time till n is exhausted
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // Handle negative exponents by taking the reciprocal
        if (n < 0) {
            x = 1 / x;
            n = -n; 
            //make the n possitive
        }

        return power(x, n);
    }

    private double power(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double half = power(x, n / 2);

        // Use exponentiation by squaring
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x; //if it odd then an extra x needed to be added
        }
    }
}
