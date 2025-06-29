class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

        return recursiveHelper(m - 1, n - 1, obstacleGrid, dp);
    }

    int recursiveHelper(int m, int n, int[][] obstacleGrid, int[][] dp){
        if(m < 0 || n < 0){
            return 0;
        }

        if(obstacleGrid[m][n] != 0){
            return 0;
        }

        if(m == 0 && n == 0){
            return 1;
        }

        if(dp[m][n] != -1) return dp[m][n];

        int up = recursiveHelper(m - 1, n, obstacleGrid, dp);
        int left = recursiveHelper(m, n - 1, obstacleGrid, dp);

        int totalPaths = up + left;
        dp[m][n] = totalPaths;

        return totalPaths;
    }
}