class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };

        // Check for the first occurence of target;
        int start = searchTargetIndex(nums, target, true);
        int end = searchTargetIndex(nums, target, false);
        ans[0] = start;
        ans[1] = end;

        return ans;
    }

    // This function returns the index value of target
    int searchTargetIndex(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                // Potential ans found
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}