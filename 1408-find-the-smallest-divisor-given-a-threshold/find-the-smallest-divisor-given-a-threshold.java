class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
         Arrays.sort(nums);

        int start = 1;
        int end = nums[nums.length - 1]; //take the maximum element in the array

        int tempAns = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == 0) return tempAns;

            int sum = getSum(nums, mid);

            if (sum <= threshold) {
                tempAns = mid;
                end = mid - 1;
            } else {
                start = mid + 1;    //keep increasing the divisor
            }
        }

        return tempAns;

    }

    public int getSum(int[] arr, int divisor) {
        int sum = 0;
        for (int j : arr) {
            int q = j / divisor;

            if ( j % divisor != 0 || q == 0) {
                q += 1;
            }
            sum += q;
        }

        return sum;
    }
}