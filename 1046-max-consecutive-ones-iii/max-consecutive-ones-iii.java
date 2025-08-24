class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, maxLen = 0;
        int zeros = 0;
        int len = 0;

        while (r < nums.length) {
            int curr = nums[r];

            if (curr == 0) {
                zeros++;
            }

            // break condition
            if (zeros > k) {
                // if the encountered number is zero
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }

            
            maxLen = Math.max(maxLen, r - l + 1);

            r++;
        }

        return maxLen;

    }
}