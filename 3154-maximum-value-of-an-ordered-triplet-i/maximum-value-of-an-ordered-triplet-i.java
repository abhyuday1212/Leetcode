class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = Long.MIN_VALUE;
        // System.out.println(ans);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    long temp = (long)(nums[i] - nums[j]) * nums[k];
                    System.out.println(temp);

                    if (ans < temp) {
                        ans = temp;
                    }
                    // ans = Math.max(temp,ans);

                    ans = ans < 0 ? 0 : ans;
                }
            }
        }

        if (ans < 0) {
            return 0;
        }

        return ans;
    }
}