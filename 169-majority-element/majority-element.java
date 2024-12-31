class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
         int majorityCount = nums.length / 2;


        for (int everyNum : nums) {
            int count = countMap.getOrDefault(everyNum, 0) + 1;
            if (count > majorityCount) {
                return everyNum; // Return as soon as we find the majority element
            }
            countMap.put(everyNum, count);
        }
        return -1;
    }

    // Time Limit Exceeded
    // public int majorityElement(int[] nums) {
    // // Brute Force: Thinking of two for Loop syntax, where we count the number of
    // // times each element appeared, and update the maxElement according to that

    // int n = nums.length;
    // int maxCount = 0; // count of last element

    // int maxElem = nums[0]; // this is the last maxium element

    // for (int i = 0; i < n; i++) {
    // int count = 0;
    // int currentElem = nums[i];

    // for (int j = 0; j < n; j++) {

    // // if (currentElem)

    // if (nums[j] == currentElem) {
    // count++;
    // // Allow Only if you are accessing first element or the current element is
    // same
    // // as the previous element
    // if (count > maxCount && count >= n / 2) {
    // maxCount = count;
    // maxElem = currentElem;
    // }

    // }

    // // else the counter should increase as usual
    // }
    // }

    // return maxElem;
    // }
}