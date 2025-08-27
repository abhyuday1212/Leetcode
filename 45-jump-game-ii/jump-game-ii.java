class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int jumps = 0;
        int l = 0, r = 0;

        while (r < n - 1) {
            int farthest = 0;

            // explore all indices in current range [l, r]
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            l = r + 1;
            r = farthest;
            jumps += 1;
        }

        return jumps;
    }
}