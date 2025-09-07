class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        
        int[][] dp = new int[n][W + 1];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        
        return knapsackHelper(W, val, wt, n - 1, dp);
    }
    
    static int knapsackHelper(int W, int[] val, int[] wt, int index, int[][] dp){
        // base case
        if(index == 0){
            if(W >= wt[index]){
                // add this to knapsack
                return val[index];
            }
            else{
                return 0;
            }
        }
        
        // self task
        int curVal = val[index];
        int curWt = wt[index];
        
        if(dp[index][W] != -1){
            return dp[index][W];
        }
        
        // recursion
        // not take
        int notTakeVal = knapsackHelper(W, val, wt, index - 1, dp);
        // take
        
        int takeVal = Integer.MIN_VALUE;
        
        if(W >= curWt){
            takeVal =  curVal + knapsackHelper(W - curWt, val, wt, index - 1, dp);
        }
        
        return dp[index][W] = Math.max(notTakeVal, takeVal);
    }
}
