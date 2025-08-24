class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0; 
        int r = 0;
        int n = nums.length;
        int zeroCount = 0;
        int maxLen = 0;

        while(r < n){
            int cur = nums[r];

            if(cur == 0){
                 zeroCount++;
            }

            while(zeroCount > 1 && l < n){
                if(nums[l] == 0){
                    zeroCount--;
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l);

            r++;
        }

        return maxLen;
    }
}