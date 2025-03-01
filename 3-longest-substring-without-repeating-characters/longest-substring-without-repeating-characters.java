class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, maxLen = 0;
        int currLen = 0;

        Map<Character, Integer> mp = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char current = s.charAt(r);
            if (mp.containsKey(current) && mp.get(current) >= l) {
                l = mp.get(current) + 1;
            }

            mp.put(current, r);
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}