
// This problem requires Dynamic programming
class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        
        int ans = subsetTargetSum(nums, n, target, n - 1, dp);
        
        return ans;
    }
    
    int subsetTargetSum(int[] nums, int n, int target, int index, int[][] dp){
        if (index == 0) {
            if (target == 0 && nums[0] == 0) return 2;
            if (target == 0 || target == nums[0]) return 1;
            return 0;
        }
        
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        
        // take not take method
        int notTakenCount = subsetTargetSum(nums, n, target, index - 1, dp);
        // System.out.println("nottaken-ans-"+ notTakenAns);
        int takenCount = 0;
        if(target >= nums[index]){
            takenCount = subsetTargetSum(nums, n, target - nums[index], index - 1, dp);
        }
        
        // System.out.println("taken-ans-" + takenAns);
        // System.out.println("count-"+ count);
        dp[index][target] = (notTakenCount + takenCount);
        return dp[index][target];
    }
    
     
}