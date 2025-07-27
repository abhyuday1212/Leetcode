class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0;
        int count = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();
        // prefixSum, frequency

        mp.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            if (mp.containsKey(prefixSum - k)) {
                count += mp.get(prefixSum - k);
            }

            mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}