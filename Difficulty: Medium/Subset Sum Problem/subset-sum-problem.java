class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum + 1];
        // first [ ] represents -> index
        // seccond [ ] represents => target
        
        if(isTargetExists(n - 1, arr, sum, dp)) return true;
        
        return false;
    }
    
    static Boolean isTargetExists(int i, int[] arr, int target, Boolean[][] dp){
        if(target == 0){
            return true;
        }
        
        if(i < 0){
            return false;
        }
        
        if(i == 0){
            if(target == arr[0]){
                return true;
            }
            
            return false;
        }
        
        if(dp[i][target] != null) return dp[i][target];
        
        // take not take method
        boolean notTake = isTargetExists(i - 1, arr, target, dp);
        boolean take = false;
        
        if(target >= arr[i]){
            take = isTargetExists(i - 1, arr, target - arr[i], dp);
        }
        
        
        Boolean ans = notTake || take;
        
        dp[i][target] = ans;
        return ans;
    }
}