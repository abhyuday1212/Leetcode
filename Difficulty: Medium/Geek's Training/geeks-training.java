// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        int n = arr.length;
        int[][] dp = new int[n][4];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return helper(n - 1, 3, arr, dp);
    }
    
    int helper(int day, int last, int[][] arr,int[][] dp){
        int max = Integer.MIN_VALUE;
        
        if(day == 0){
            for(int i = 0; i < 3; i++){
                if(i != last){
                    max = Math.max(max, arr[0][i]);
                }
            }
            
            return max;
        }
        
        if(dp[day][last] != -1) return dp[day][last];
        
        // now if the day is anyother than 0
        
        for(int i = 0; i < 3; i++){
            if(i != last){
                 // if you are performing task on a given day then these are the number of points that you will earn
                int points = arr[day][i] + helper(day - 1, i, arr, dp);
                max = Math.max(max, points);
            }
        }
        
        dp[day][last] = max;
        return max;
    }
}