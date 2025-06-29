class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(grid, m - 1, n - 1, dp);
    }

    public int helper(int[][] grid, int m, int n, int[][] dp){
        if(m == 0 && n == 0){
            return grid[0][0];
        }

        if(m < 0 || n < 0){
            return (int)1e9;
        }

        if(dp[m][n] != -1) return dp[m][n];

        // move up
        int up = grid[m][n] + helper(grid, m - 1, n, dp);

        // move left
        int left = grid[m][n] + helper(grid, m, n - 1, dp);

        int minCostPath = Math.min(up, left);
        dp[m][n] = minCostPath;

        return minCostPath;
    }    
    
    
}