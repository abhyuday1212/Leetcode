class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // since n/2 times can have only 1 element in similar way, n/2 will have only
        // two elements in the ans
        // Modified Moor's Voting Algorithm
        List<Integer> ans = new ArrayList<>();

        if (nums.length == 1) {
            ans.add(nums[0]);
            return ans;
        }
        ;

        int count1 = 0;
        int element1 = nums[0];

        int count2 = 0;
        int element2 = nums[1];

        for (int num : nums) {
            if (num == element1) {
                count1++;
            } else if (num == element2) {
                count2++;
            } else if (count1 == 0) {
                element1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                element2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: Verify the candidates.
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == element1) {
                count1++;
            } else if (num == element2) {
                count2++;
            }
        }

        int n = nums.length;
        if (count1 > n / 3)
            ans.add(element1);
        if (count2 > n / 3)
            ans.add(element2);

        return ans;

    }
}