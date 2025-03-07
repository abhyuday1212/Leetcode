class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        /*
         * Since the question has asked... sum == goal
         * But we will find sum <= goal
         * => for that we do,
         * func(nums, goal) - func(nums, goal - 1);
         */

        return numSubarraysWithSumEqualOrLess(nums, goal) - numSubarraysWithSumEqualOrLess(nums, goal - 1);
    }

    public int numSubarraysWithSumEqualOrLess(int[] nums, int goal) {
        int l = 0, r = 0, count = 0;
        int subArrSum = 0;
        int n = nums.length;

        // This is for the scenario when the goal is given 0. as after subtracting it
        // will become (0 - 1 = 0)
        if (goal < 0)
            return 0;

        while (r < n) {
            subArrSum += nums[r];

            // break condition
            while (subArrSum > goal) {
                subArrSum -= nums[l];
                l++;
            }

            count += r - l + 1;

            r++;
        }

        return count;
    }
}