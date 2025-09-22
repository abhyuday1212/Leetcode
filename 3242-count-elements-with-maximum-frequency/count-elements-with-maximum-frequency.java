class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        // key, freq

        int maxFreq = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, mp.get(nums[i]));
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (mp.get(nums[i]) == maxFreq) {
                ans += mp.get(nums[i]);
                mp.put(nums[i], 0);
            }
        }

        return ans;

    }
}