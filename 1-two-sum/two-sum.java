class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>(); 
        // hashmap to store complements

        for(int i = 0; i < n; i++){
            int complement = target - nums[i];

            if(mp.containsKey(complement)){
                return new int[]{mp.get(complement), i};
            }

            mp.put(nums[i], i);
        }

        return new int[0];
    }
}