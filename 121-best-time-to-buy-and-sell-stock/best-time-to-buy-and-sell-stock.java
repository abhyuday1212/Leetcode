class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minVal = prices[0];

        for(int i = 0 ; i < prices.length; i++){
            int cost = prices[i] - minVal;
            profit = Math.max(cost, profit);
            minVal = Math.min(prices[i], minVal);
            //DP
            // updating the minimum value at which the stock should be bought for maximumProfit
            // Updating the value will help in knowing about the minimum element till i-1 when calculating the cost
        }

        return profit;
        
    }
}