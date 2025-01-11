class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (nums[mid] == target)
                return true;

            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start = start + 1;
                end = end - 1;
                continue;
            }    

            if (nums[start] <= nums[mid]) { // This part of the numsay is left sorted
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1; // remove the right part
                } else {
                    start = mid + 1; // remove the starting part
                }
            } else { // this part of the numsay is right sorted
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1; // remove the left part of the numsay
                } else {
                    end = mid - 1; // remove end part otherwise
                }
            }

        }

        return false;
    }
}