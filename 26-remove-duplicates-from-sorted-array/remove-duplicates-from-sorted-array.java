class Solution {

    public int removeDuplicates(int[] nums) {

// M-1
        // if (nums.length == 0)
        //     return 0;

        // // `k` is the index for the unique elements
        // int k = 0;

        // for (int i = 1; i < nums.length; i++) {
        //     // If the current element is different from the last unique element
        //     if (nums[i] != nums[k]) {
        //         k++;
        //         nums[k] = nums[i];
        //     }
        // }

        // return k + 1;

        int ans = recursiveApproach(nums,0,0);
        return ans;

    }

// M-2
    public int recursiveApproach(int[] nums, int index, int count) {
        if (nums.length == 0) {
            return 0;
        }
        if (index >= nums.length) {
//            nums[count] = nums[nums.length-1];
            return count;
        }
        if (count == 0 || nums[index] != nums[count - 1]) {
            nums[count] = nums[index];
            return recursiveApproach(nums, index + 1, count + 1);
        }

        // Skip the current element if it's a duplicate
        return recursiveApproach(nums, index + 1, count);
    }
}