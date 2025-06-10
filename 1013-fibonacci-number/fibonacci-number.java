class Solution {
    // -------- M-2: Tabulation Approach using Tabulation(Bottom up)
    public int fib(int n) {
        if (n < 2)
            return n;

        int prev2 = 0; // fib(0)
        int prev1 = 1; // fib(1)
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2; // fib(i) = fib(i-1) + fib(i-2)
            prev2 = prev1; // Move prev2 to prev1
            prev1 = current; // Move current to prev1
        }

        return current;
    }

    //--------- M-1: Recursive Approach using DP
    // S-0:
    // private Map<Integer, Integer> dp = new HashMap<>(); // you can also create a helper function and pass this into that

    // public int fib(int n) {
    //     // step 3
    //     if (n < 2) {
    //         return n;
    //     }

    //     //S-2:
    //     if (dp.containsKey(n)) {
    //         return dp.get(n);
    //     }

    //     //Linear recursive Relation
    //     // S-1:
    //     int result = fib(n - 1) + fib(n - 2);
    //     dp.put(n, result);
    //     return result;
    // }
}