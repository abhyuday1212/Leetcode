class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = numbers.length;

        for(int i = 0; i < n; i++){
            int complement = target - numbers[i];

            if(!mp.isEmpty() && mp.containsKey(complement)){
                return new int[]{mp.get(complement) + 1, i + 1};
            }

            mp.put(numbers[i], i);
        }

        return new int[]{-1};
    }
}