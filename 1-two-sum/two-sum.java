class Solution {
 static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i <= nums.length; i++) {
            int firstElement = nums[i];
            for (int j = i+1; j <= nums.length-1; j++) {
                int seccondElem = nums[j];
                int sum = seccondElem + firstElement;
                if (sum == target) {
//                    finalAns.add(i);
//                    finalAns.add(j);
//                    return finalAns;

                    return new int[]{i, j};
                }

            }
        }

        return new int[0];

    }
}