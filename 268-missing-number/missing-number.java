class Solution {
    public int missingNumber(int[] nums) {
          int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i];
            // Check
            if (nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                //swap
                swap(nums, i, correctIndex);
            } else {
                // move
                i++;
            }
        }

        for(int index = 0 ; index <nums.length; index++){
            if(index  != nums[index]){
               // Jha index equal nhi h whi basically missing value hogi
                return index;
            }
        }

        return nums.length;
    }

       static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

    }
}