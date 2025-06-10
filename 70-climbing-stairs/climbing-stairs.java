class Solution {
    HashMap<Integer, Integer> mp = new HashMap<>();

    public int climbStairs(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;

        // memorize it
        if(mp.containsKey(n)){
            return mp.get(n);
        }

        // 1 steps
        int left = climbStairs(n - 1);
        mp.put(n-1, left);

        // 2 steps
        int right = climbStairs(n - 2);
        mp.put(n-2, right);
    
        return left + right;
    }
}