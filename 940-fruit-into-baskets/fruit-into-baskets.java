class Solution {
    // Tc: O(2n)
    // Sc O(3), elements being stored in map
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0;
        int maxCount = 0;
        int n = fruits.length;
        Map<Integer, Integer> mp = new HashMap<>();

        while (r < n) {
            int curr = fruits[r];
            mp.put(curr, mp.getOrDefault(curr, 0) + 1);

            // break condition
            while (mp.size() > 2) {
                // In this we have to decrease the count of that particular by 1;
                int freq = mp.get(fruits[l]);
                mp.put(fruits[l], freq - 1);

                if (mp.get(fruits[l]) <= 0) {
                    mp.remove(fruits[l]);
                }

                l++;
            }

            if (mp.size() <= 2) {
                maxCount = Math.max(maxCount, r - l + 1);
            }

            System.out.println(mp);

            r++;
        }

        return maxCount;
    }
}