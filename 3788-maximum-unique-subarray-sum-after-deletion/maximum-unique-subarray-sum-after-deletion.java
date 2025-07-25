class Solution {
     public int maxSum(int[] nums) {
        Set<Integer> positives = new HashSet<>();
        int maxNeg = Integer.MIN_VALUE;

        // 1) Partition into positives (into a set) and find the largest negative
        for (int x : nums) {
            if (x >= 0) {
                positives.add(x);
            } else {
                maxNeg = Math.max(maxNeg, x);
            }
        }

        // 2) Sum up all the distinct non‑negative values
        int sum = 0;
        for (int x : positives) {
            sum += x;
        }

        // 3) If there was at least one non‑negative, we used them; otherwise fallback to maxNeg
        return positives.isEmpty() ? maxNeg : sum;
    }

    // public int maxSum(int[] nums) {
    //     int left = 0;
    //     int right = 0;
    //     long maxSum = Long.MIN_VALUE, sum = 0; 

    //     int n = nums.length;

    //     if (n == 1)
    //         return nums[0];

    //     HashSet<Integer> hs = new HashSet<>();

    //     while (right < n) {
    //         int cur = nums[right];

    //         if (sum < 0) {
    //             sum = 0;
    //             hs.clear();
    //             left = right;
    //         }

    //         if (hs.contains(cur)) {
    //             // Passed 847 test cases/ 927
    //             // left = right;
    //             // sum = 0;
    //             while (hs.contains(cur)) {
    //                 sum -= nums[left];
    //                 hs.remove(nums[left]);
    //                 left++;
    //             }
    //             // eventually left will come at a position from where the right elements feals like it is unique
    //         }
    //         // the number is +ve or -ve & hashSet does not contain it
    //         sum += cur;
    //         hs.add(cur);

    //         // right++;
    //         // if(cur < 0){
    //         //     maxSum = Math.max(maxSum, cur);
    //         // }
    //         // maxSum = Math.max(maxSum, sum);
    //         maxSum = Math.max(maxSum, sum);
    //         maxSum = Math.max(maxSum, (long)cur);

    //         right++;
    //     }

    //     return (int) maxSum;
    // }
}