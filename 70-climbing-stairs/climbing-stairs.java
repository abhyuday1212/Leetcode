class Solution {
    HashMap<Integer, Integer> mp = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 0)
            return 1; //n == 0 → return 1 means “we’ve found one valid way that ends exactly at the top (no more steps needed).

        if (n == 1)
            return 1; // n == 1 → return 1 means “from one step below, there’s exactly one move (a single-step) to finish.”

        // memorize it
        if (mp.containsKey(n)) {
            return mp.get(n);
        }

        // 1 steps + 2 steps
        int ways = climbStairs(n - 1) + climbStairs(n - 2);
        mp.put(n, ways);

        return ways;
    }
}