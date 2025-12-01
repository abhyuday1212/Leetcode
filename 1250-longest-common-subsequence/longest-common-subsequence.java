class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return f(m - 1, n - 1, text1, text2, dp);
    }

    public int f(int idx1, int idx2, String t1, String t2, int[][] dp){
        if(idx1 < 0 || idx2 < 0){
            return 0;
        }

        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }

        // if character matches
        if(t1.charAt(idx1) == t2.charAt(idx2)){
            dp[idx1][idx2] = 1 + f(idx1 - 1, idx2 - 1, t1, t2, dp);
        }
        else{ // character does not matches
            dp[idx1][idx2] = Math.max(f(idx1, idx2 - 1, t1, t2, dp), f(idx1 - 1, idx2, t1, t2, dp));
        }

        return dp[idx1][idx2];
    }
}