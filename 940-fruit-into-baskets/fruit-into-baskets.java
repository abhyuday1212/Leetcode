class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0;

        int n = fruits.length;
        int maxCount = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        while (right < n) {
            int cur = fruits[right];
            mp.put(cur, mp.getOrDefault(cur, 0) + 1);

            // break condition;
            while (mp.size() > 2) {
                int freq = mp.get(fruits[left]);
                mp.put(fruits[left], freq - 1);

                if (mp.get(fruits[left]) <= 0) {
                    mp.remove(fruits[left]);
                }

                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }

        return maxCount;
    }
}