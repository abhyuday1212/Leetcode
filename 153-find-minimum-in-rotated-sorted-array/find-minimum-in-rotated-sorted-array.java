class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int tempAns = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[start] <= nums[mid]) {
                // left part is sorted, take the min element
                tempAns = Math.min(tempAns, nums[start]);
                start = mid + 1;
            } else {
                // right part is sorted, take the min element
                tempAns = Math.min(tempAns, nums[mid]);
                end = mid - 1;
            }
        }

        return tempAns;
    }
}