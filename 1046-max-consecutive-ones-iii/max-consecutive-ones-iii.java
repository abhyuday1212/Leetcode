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
            while (zeros > k) {
                // if the encountered number is zero
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }

            // Check the length
            if (zeros <= k) {
                len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }

            r++;
        }

        return maxLen;

    }
}