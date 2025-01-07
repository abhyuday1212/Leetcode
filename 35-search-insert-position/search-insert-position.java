class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;

        if(target > nums[end]) return nums.length;

        else if( target < nums[0]) return 0;

        int ceil = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                // Possible ceil value
                ceil = mid;
                end = mid - 1; // Search for a closer ceil on the left
            } else {
                start = mid + 1; // Search on the right
            }
        }

        return ceil;
    }
}