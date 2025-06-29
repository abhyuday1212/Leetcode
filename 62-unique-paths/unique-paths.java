// Approach : 2 -- DP
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(m - 1, n - 1, dp);
    }

    int helper(int m, int n, int[][] dp){
        if(m == 0 && n == 0){
            // Destination reached, count
            return 1;
        }

        if(m < 0 || n < 0){
            // dont count this path
            return 0;
        }

        if(dp[m][n] != -1) return dp[m][n];

        // S: 2 -Do all stuff
        int up = helper(m - 1, n, dp); // decrease row
        int left = helper(m, n - 1, dp); // decrease col

        int totalWays = up + left;
        dp[m][n] = totalWays;
        return totalWays; // return all ways
    }
}

// Approach 1: BRUT - Recursion
// class Solution {
//     public int uniquePaths(int m, int n) {
//         return helper(m - 1, n - 1);
//     }

//     int helper(int m, int n){
//         if(m == 0 && n == 0){
//             // Destination reached, count
//             return 1;
//         }

//         if(m < 0 || n < 0){
//             // dont count this path
//             return 0;
//         }

//         // S: 2 -Do all stuff
//         int up = helper(m - 1, n); // decrease row
//         int left = helper(m, n - 1); // decrease col

//         return up + left; // return all ways
//     }
// }