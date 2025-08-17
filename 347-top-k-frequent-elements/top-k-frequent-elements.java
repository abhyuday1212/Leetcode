class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        // element, freq

        int n = nums.length;

        for(int i = 0; i < n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> map2List = new ArrayList<>(mp.entrySet());
        map2List.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        int[] ans = new int[k];

        for(int i = 0; i < k && i < map2List.size(); i++){
            ans[i] = map2List.get(i).getKey();
        }

        return ans;
    }
}