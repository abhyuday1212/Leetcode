class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        // Build frequency map (no need to track maxChar here)
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }

        int result = 0;
        // Try the sliding window approach for every character in the map
        for (char candidate : mp.keySet()) {
            result = Math.max(result, longestRepeatingChars(s, k, candidate));
        }

        return result;
    }

   public int longestRepeatingChars(String str, int k, char maxChar) {
        int l = 0, r = 0, maxLen = 0;
        int zeros = 0;
        int len = 0;
        int n = str.length();
        char[] charArr = str.toCharArray();

        while (r < n) {
            int curr = charArr[r];

            if (curr != maxChar) {
                zeros++;
            }

            // break condition
            while (zeros > k && l < n) {
                // if the encountered number is zero or different from the maxchar
                if (charArr[l] != maxChar) {
                    zeros--;
                }
                l++;
            }
            
            maxLen = Math.max(maxLen,  r - l + 1);
            r++;
        }

        return maxLen;

    }
}