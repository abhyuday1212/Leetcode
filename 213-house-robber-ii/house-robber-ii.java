class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; 
        Arrays.fill(dp, -1);

        if(n == 1) return nums[0];
        
        int firstBihari = robHelper(nums, dp, 0, n -1);
        Arrays.fill(dp, -1);
        int seccondBihari = robHelper(nums, dp, 1, n);

        return Math.max(firstBihari, seccondBihari);
    }

    private int robHelper(int[] nums, int[] dp, int i, int end) {
        if (i >= end) return 0;

        if(dp[i] != -1) return dp[i];

        // Either rob the current house and skip the next one
        int robCurrent = nums[i] + robHelper(nums, dp, i + 2, end);

        // Or skip this house and rob the next one
        int skipCurrent = robHelper(nums, dp, i + 1, end);

        int maxMoney = Math.max(robCurrent, skipCurrent);
        dp[i] = maxMoney;
        return maxMoney;
    }
}