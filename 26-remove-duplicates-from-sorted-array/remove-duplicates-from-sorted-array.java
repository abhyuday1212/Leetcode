class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        // `k` is the index for the unique elements
        int k = 0;

        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the last unique element
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];
            }
        }

        return k + 1;

    }
}