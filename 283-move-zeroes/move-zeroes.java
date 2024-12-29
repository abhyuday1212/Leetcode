class Solution {
    public void moveZeroes(int[] nums) {

        List<Integer> temp = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp.add(nums[i]);
            }
        }

        // Step: 2
        for (int i = 0; i < n; i++) {
            if (i >= temp.size()) {
                nums[i] = 0;
            }
            else{
            nums[i] = temp.get(i);
            }
        }


    }
}