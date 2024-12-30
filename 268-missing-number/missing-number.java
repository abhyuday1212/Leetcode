class Solution {
    // Optimal:
    // 1- using Mathematical formula
    // 2- using XOR

    // Better Ways
    // Hashing
    // Quick Sort

    // Brute
    // Linear search with 2 for Loops

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor1 = 0, xor2 =0; 

        for(int i = 0; i < n; i++){
            xor2 = xor2 ^ nums[i]; //elements ka xor
            xor1 = xor1 ^ (i+1); //index ka xor
        }

        //Ab index^elements se same elements 0 ho jayenge aur unique wla bhr aa jayega

        return xor1^xor2;

    }

    // Better Way-1
    // public int missingNumber(int[] nums) {
    // int i = 0;
    // while (i < nums.length) {
    // int correctIndex = nums[i];
    // // Check
    // if (nums[i] < nums.length && nums[i] != nums[correctIndex]) {
    // //swap
    // swap(nums, i, correctIndex);
    // } else {
    // // move
    // i++;
    // }
    // }

    // for(int index = 0 ; index <nums.length; index++){
    // if(index != nums[index]){
    // // Jha index equal nhi h whi basically missing value hogi
    // return index;
    // }
    // }

    // // last element
    // return nums.length;
    // }

    // static void swap(int[] arr, int first, int second) {
    // int temp = arr[first];
    // arr[first] = arr[second];
    // arr[second] = temp;

    // }
}