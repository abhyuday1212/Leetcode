class Solution {
    public int maximumCount(int[] nums) {
        // approach using binary search
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int neg = 0;

        // find the negative ending index with this loop
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int curr = nums[mid];

            if (curr < 0) {
                // it is possible that the current index is probable ans, but we will find
                // better
                neg = mid + 1; // assign the mid index as one of the possible ans
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }

        // the neg index will automatically point to the last negative index
        int index = neg;
        while (index < n  && nums[index] == 0) {
            index++;
        }

        int pos = n - index;
        int maxAns = Math.max(pos, neg);

        return maxAns;
    }

    // Brut: TC -> O(n)
    // public int maximumCount(int[] nums) {
    // int neg = 0;
    // int pos = 0;
    // int n = nums.length;

    // int index = 0;
    // while (index < n) {
    // int curr = nums[index];
    // if (curr == 0) {
    // index++;
    // continue;
    // } else if (curr > 0) {
    // break;
    // }
    // System.out.println(curr);
    // neg++;
    // index++;
    // }

    // pos = n - index;

    // return Math.max(pos, neg);
    // }
}