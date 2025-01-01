class Solution {

    // Brute: o(n^3)
    // 204 / 210 test case passed:
    // Not optimal but it is a good solution
    // It was similar to this but the inside sum calculation was also done via a for
    // loop using k th pointer

    // Better: o(n^2)

    // Optimal: Kadanes Algorithm
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // long maxSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
                continue;
            }
        }

       return maxSum;
    }
}