class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;
        int n = nums.length;

        int index = 0;
        while (index < n) {
            int curr = nums[index];
            if (curr == 0) {
                index++;
                continue;
            } else if (curr > 0) {
                break;
            }
            System.out.println(curr);
            neg++;
            index++;
        }

        pos = n - index;

        return Math.max(pos, neg);
    }
}