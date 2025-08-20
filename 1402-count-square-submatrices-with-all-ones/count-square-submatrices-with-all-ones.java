class Solution {
    int result = 0;

    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        solve(matrix, dp, 0, 0);
        return result;
    }

    public int solve(int[][] matrix, int[][] dp, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length) {
            return 0;
        }

        // if ans exist in dp, return it
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int right = solve(matrix, dp, row, col + 1);
        int diagonal = solve(matrix, dp, row + 1, col + 1);
        int bottom = solve(matrix, dp, row + 1, col);

        if (matrix[row][col] == 1) {
            dp[row][col] = 1 + Math.min(right, Math.min(diagonal, bottom));
            result += dp[row][col];
        } else {
            dp[row][col] = 0;
        }

        return dp[row][col];
    }
}