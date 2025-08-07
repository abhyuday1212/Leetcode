class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int globalMax = nums[0];

        for(int i = 1; i < nums.length; i++){
            int cur = nums[i];

            if(cur < 0){
                int newTemp = curMax;
                curMax = curMin;
                curMin = newTemp;
            }

            curMax = Math.max(cur, curMax * cur);
            curMin = Math.min(cur, curMin * cur);

            globalMax = Math.max(globalMax, curMax);
        }


        return globalMax;
    }
}