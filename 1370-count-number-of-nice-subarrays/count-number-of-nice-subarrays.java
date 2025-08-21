class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        /*
         * Since the question has asked... sum == goal
         * But we will find sum <= goal
         * => for that we do,
         * func(nums, goal) - func(nums, goal - 1);
         */

        return numSubarraysWithSumEqualOrLess(nums, k) - numSubarraysWithSumEqualOrLess(nums, k - 1);
    }

    public int numSubarraysWithSumEqualOrLess(int[] nums, int goal){
        int l = 0, r = 0;
        int n = nums.length;

        int count = 0;
        int sum = 0;

        if(goal < 0){
            return 0;
        }

        while(r < n){
            sum += nums[r]%2;

            while(sum > goal){
                sum -= nums[l]%2;
                l++; 
            }

            count += r - l + 1;
            r++;
        }

        return count;
    }
}