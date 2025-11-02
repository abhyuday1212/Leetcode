class Solution {
    // TC: O(N x 2)
    // SC: O(N x 2)

    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n == 1)
            return 0;

        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 1) {
                    int takenProfit = -prices[index] + dp[index + 1][0] ;
                    int notTakenProfit = dp[index + 1][1];

                    profit = Math.max(takenProfit, notTakenProfit);
                } else {
                    // selling on this day
                    int takenProfit = prices[index] + dp[index + 1][1];
                    int notTakenProfit = dp[index + 1][0];

                    profit = Math.max(takenProfit, notTakenProfit);
                }

                dp[index][buy] = profit;
            }
        }

        return dp[0][1];
    }
    // ----------------- recursion
        // TC: O(N x 2)
    // SC: O(N x 2) + O(N)
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;

    //     if(n == 1) return 0;

    //     int[][] dp = new int[n][n];

    //     for(int[] nums:dp){
    //         Arrays.fill(nums, -1);
    //     }

    //     return recursiveHelper(prices, n, 0, 1, dp);
    // }

    // // buy = 0 == > sell
    // // buy = 1 == > bought on that day

    // public int recursiveHelper(int[] prices, int n, int index, int buy, int[][] dp) {
    //     if (index == n) {
    //         return 0;
    //     }

    //     if(dp[index][buy] != -1){
    //         return dp[index][buy];
    //     }

    //     int profit = 0;

    //     if (buy == 1) {
    //         int takenProfit = -prices[index] + recursiveHelper(prices, n, index + 1, 0, dp);
    //         int notTakenProfit = recursiveHelper(prices, n, index + 1, 1, dp);

    //         profit = Math.max(takenProfit, notTakenProfit);
    //     } else {
    //         // selling on this day
    //         int takenProfit = prices[index] + recursiveHelper(prices, n, index + 1, 1, dp);
    //         int notTakenProfit = recursiveHelper(prices, n, index + 1, 0, dp);

    //         profit = Math.max(takenProfit, notTakenProfit);
    //     }

    //     dp[index][buy] = profit;

    //     return profit;
    // }
}