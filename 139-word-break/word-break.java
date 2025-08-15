class Solution {
    // Hume check karna hai ki kya s ko aise tod sakte hain (segment kar sakte hain) ki har segment wordDict me ho.
    // The intuition is that you will have consider every combination of words in the wordDict, moreover these words can be used more than once when computing the combinations.
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // Set<String> dict = new HashSet<>(wordDict);

        for (int i = 1; i <= s.length(); i++) {
            // for (int j = 0; j < i; j++) {
            //     if (dp[j] && dict.contains(s.substring(j, i))) {
            //         dp[i] = true;
            //         break;
            //     }
            // }
             for (String w : wordDict) {
                int start = i - w.length();
                if (start >= 0 && dp[start] && s.substring(start, i).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}