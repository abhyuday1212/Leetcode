class Solution {
     public void rotate(int[] nums, int k) {

        // make a copy of nums array
        List<Integer> temp = new ArrayList<>();

        if (nums.length == 0) {
            return;
        }

        if (k == nums.length) {
            return; // that array will not be rotated
        } else if (k > nums.length) {
            k = k % nums.length;
        }

        int n = nums.length;

        // Step: 1 -> Copy the first k elements in a temporary array
        // {5,6,7}
        for (int i = n-k; i < n; i++) {
            temp.add(nums[i]);
        }

        // Step: 2 -> rotate towards right/ Clockwise
        //
        for (int i = 1; i <= n-k; i++) {
            nums[n - i] = nums[(n - k) - i];
            // last index(6) = 7-4(4)
            //
        }

        // copy the remaining nums array fill
        for (int i = 0; i < k; i++) {
            nums[i] = temp.get(i);
        }

    }
}