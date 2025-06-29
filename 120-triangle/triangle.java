class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(triangle, n, 0, 0, dp);
    }
    
    int helper(List<List<Integer>> triangle, int n, int i, int j,int[][] dp){
        if(i == n -1){
            // since you are at last index, return the value of the last index
            return triangle.get(n - 1).get(j);
        }

        if(dp[i][j] != -1) return dp[i][j];

        int curVal = triangle.get(i).get(j);

        // Do all stuff
        int down = curVal + helper(triangle, n, i + 1, j, dp); // keep going down in same col
        int diagonallyDown = curVal + helper(triangle, n, i + 1, j+ 1, dp);
        
        int minPathVal = Math.min(down, diagonallyDown);
        dp[i][j] = minPathVal;
        return minPathVal;
    }
}