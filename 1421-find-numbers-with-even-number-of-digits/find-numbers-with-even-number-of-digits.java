class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if (evenNums(element)) {
                count++;
            }
        }
        return count;
    }

    public boolean evenNums(int eleVals) {
        String numStr = String.valueOf(eleVals);
        int digits = numStr.length();

        if (digits % 2 == 0) {
            return true;
        }

        return false;
    }
}