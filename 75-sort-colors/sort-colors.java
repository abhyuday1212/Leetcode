class Solution {
    // Brute: Merge Sort
    // Better: Count the number of zeros then put back and modify the array
    // Optimal: Dutch National Flag Algorithms

    // Optimal: Dutch National Flag Algorithms
    public void sortColors(int[] nums) {
        int n = nums.length;

        int low = 0, mid = 0, high = n - 1; // low, mid and high are the indexes at which elems will be placed

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
               low++;
                mid++;
                
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }

    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // Runtime: 0ms, TC: O(2n)
    // Better: Counting and then Modifying the Array
    // public void sortColors(int[] nums) {

    // int count0 = 0, count1 = 0, count2 = 0;

    // int n = nums.length;

    // for (int i = 0; i < n; i++) {
    // if (nums[i] == 0)
    // count0++;
    // else if (nums[i] == 1)
    // count1++;
    // else
    // count2++;

    // }

    // // now modify the array
    // for (int i = 0; i < count0; i++)
    // nums[i] = 0;

    // for (int i = count0; i < count0 + count1; i++)
    // nums[i] = 1;

    // for (int i = count0 + count1; i < n; i++)
    // nums[i] = 2;

    // }
}