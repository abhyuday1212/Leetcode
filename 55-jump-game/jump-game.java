// BRUT
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            maxIndex = Math.max(maxIndex, nums[i] + i);

            if(nums[i] == 0 && maxIndex < n - 1 && i >= maxIndex){
                break;
            }
            else if (maxIndex >= n - 1) {
                // System.out.println("MAxIndex: " + maxIndex);
                // System.out.println("nums[i]: " + nums[i]);
                return true;
            }
        }

        return false;
    }

    // public boolean canJump(int[] nums) {
    //     Boolean[] dp = new Boolean[nums.length];

    //     return helper(nums, 0, dp);
    // }

    // public boolean helper(int[] nums, int index, Boolean[] dp) {
    //     if (index >= nums.length || index == nums.length - 1) {
    //         return true;
    //     }

    //       if (dp[index] != null) {
    //         return dp[index];
    //     }

    //     for (int i = 1; i <= nums[index]; i++) {
    //         if (helper(nums, index + i, dp)) {
    //             return dp[index] = true;
    //         }
    //     }

    //     return dp[index] = false;
    // }
}