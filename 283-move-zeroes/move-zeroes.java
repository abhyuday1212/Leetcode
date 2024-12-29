class Solution {

    public void moveZeroes(int[] nums) {
        // Optimal

        int j = -1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1)
            return;

        for (int i = j+1; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }

    }

   public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // public void moveZeroes(int[] nums) {
    // // Brute Force
    // List<Integer> temp = new ArrayList<>();

    // int n = nums.length;

    // for (int i = 0; i < n; i++) {
    // if (nums[i] != 0) {
    // temp.add(nums[i]);
    // }
    // }

    // // Step: 2
    // for (int i = 0; i < n; i++) {
    // if (i >= temp.size()) {
    // nums[i] = 0;
    // }
    // else{
    // nums[i] = temp.get(i);
    // }
    // }

    // }
}