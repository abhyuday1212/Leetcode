class Solution {
    // int minVal = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

       int minPathSum = Integer.MAX_VALUE;
       int[][] dp = new int[n][n];

       for(int[] row: dp){
        Arrays.fill(row, Integer.MAX_VALUE);
       }
       
       for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, helper(matrix, n, n - 1, j, dp));
        }

        return minPathSum;
    }

    int helper(int[][] matrix, int n, int i, int j, int[][] dp){
        if(j < 0 || j >= n){
            return Integer.MAX_VALUE/100;
        }

        if(i == 0){
            return matrix[i][j];
        }

        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int down = helper(matrix, n, i - 1, j, dp);
        int leftDig = helper(matrix, n, i - 1, j + 1, dp);
        int rightDig = helper(matrix, n, i - 1, j - 1, dp);

        int minVal = matrix[i][j] + Math.min(down, Math.min(leftDig, rightDig));
        dp[i][j] = minVal;

        return minVal;
    }
}