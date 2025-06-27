class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return robHelper(nums, dp, 0);
    }

    private int robHelper(int[] nums, int[] dp, int i) {
        if (i >= nums.length) return 0;

        if(dp[i] != -1) return dp[i];

        // Either rob the current house and skip the next one
        int robCurrent = nums[i] + robHelper(nums, dp, i + 2);

        // Or skip this house and rob the next one
        int skipCurrent = robHelper(nums, dp, i + 1);

        int maxMoney = Math.max(robCurrent, skipCurrent);
        dp[i] = maxMoney;
        return maxMoney;
    }
}