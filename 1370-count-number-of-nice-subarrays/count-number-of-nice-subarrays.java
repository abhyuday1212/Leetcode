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

    public int numSubarraysWithSumEqualOrLess(int[] nums, int goal) {
        int l = 0, r = 0, count = 0;
        int subArrSum = 0;
        int n = nums.length;

        // This is for the scenario when the goal is given 0. as after subtracting it
        // will become (0 - 1 = 0)
        if (goal < 0)
            return 0;

        while (r < n) {
            subArrSum += (nums[r] % 2);

            // break condition
            while(subArrSum > goal){
                subArrSum -= (nums[l] % 2);
                l++;
            }

            count += r - l + 1;

            r++;
        }

        return count;
    }

}

// My Approach
// public int numberOfSubarrays(int[] nums, int k) {
// int l = 0, r = 0, numOfSubArr = 0, count = 0;
// int n = nums.length;

// while (r < n) {
// int curr = nums[r];

// // break condition
// if (curr % 2 != 0) {
// // if odd
// count++;
// }

// while (count > k && l < n) {
// if (nums[l] % 2 != 0) {
// // if odd
// count--;
// }
// l++;

// if (nums[l] % 2 != 0 && l < n)
// count++;
// }

// if (count == k) {
// numOfSubArr++;
// }

// r++;
// }

// while (l < n) {
// int curr = nums[l];

// // break condition
// if (curr % 2 != 0) {
// // if odd then only increase the count
// count--;
// }

// if (count == k) {
// numOfSubArr++;
// }

// l++;
// }

// return numOfSubArr;
// }