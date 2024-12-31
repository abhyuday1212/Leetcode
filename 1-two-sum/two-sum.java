class Solution {
    // Brute: Simple For Loop and then adding the element
    // Better: Hashing (Optimal way if we need to return the index also)
    
    // Optimal: 2 Pointer Approach 
    // Only optimal for Varity 1 problems where we need to return the boolean values as we need to sort the array, and if we sort the array then indexes will get disturb with the end pointer at last and then checking if sum is greater than or less than the current two sum elements

    static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i <= nums.length; i++) {
    int firstElement = nums[i];
    for (int j = i + 1; j <= nums.length - 1; j++) {
    int seccondElem = nums[j];
    int sum = seccondElem + firstElement;
    if (sum == target) {
    // finalAns.add(i);
    // finalAns.add(j);
    // return finalAns;

    return new int[] { i, j };
    }

    }
    }

    return new int[0];

    }
}