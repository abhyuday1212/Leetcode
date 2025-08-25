class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        int ans = helper(coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int helper(int[] coins, int amount, Integer[] dp){
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;

        if (dp[amount] != null) return dp[amount];

        int min = Integer.MAX_VALUE;

        for(int coin:coins){
            int res = helper(coins, amount - coin, dp);
            if(res != Integer.MAX_VALUE){
                min = Math.min(min, res + 1);
            }
        }
        
        dp[amount] = min;
        return min;
    }
    // Greedy Approach
    // Thought of a approach, sort the coins, then keep moving to next coins if the coins addition excedd
    // public int coinChange(int[] coins, int amount) {
    //     int ans = -1;

    //     int n = coins.length;

    //     Arrays.sort(coins); // dual‑pivot Quicksort, O(n log n)

    //     for (int i = 0, j = coins.length - 1; i < j; i++, j--) {
    //         int tmp = coins[i];
    //         coins[i] = coins[j];
    //         coins[j] = tmp;
    //     }
        
    //     System.out.println("Curr---------: "+ Arrays.toString(coins));

    //     int count = 0;

    //     int totalVal = 0;

    //     for (int i = 0; i < n; i++) {
    //         System.out.println("Curr: "+ coins[i]);

    //         while (totalVal + coins[i] <= amount) {
    //             count++;
    //             totalVal += coins[i];
    //             System.out.println("Total Val: "+ totalVal);
    //         }

    //         if (totalVal == amount) {
    //             System.out.println("Ans: "+ ans);
    //             ans = count;
    //             break;
    //         }
    //     }

    //     return ans;
    // }
}