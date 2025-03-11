class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0, r = 0, count = 0;
        int n = s.length();

        int lastA = -1, lastB = -1, lastC = -1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == 'a') {
                lastA = i;
            } else if (ch == 'b') {
                lastB = i;
            } else if (ch == 'c') {
                lastC = i;
            }

            // Only when all three characters have been seen at least once
            int minIndex = Math.min(lastA, Math.min(lastB, lastC));

            if (minIndex != -1) {
                // All substrings starting from indices 0 to minIndex ending at i are valid
                count = count + (minIndex + 1);
            }
        }

        return count;
    }
}