
class Solution {
    int countPartitions(int[] arr, int d) {
        int n = arr.length;
        //---
        int totalSum = 0;
        for(int elem: arr){
            totalSum += elem;
        }
        
        // totalSum - d -> need to be possitive
        // toalSum - d -> has to be even
        if((totalSum - d) < 0 || (totalSum - d) % 2 != 0) return 0;
        
        int target = (totalSum - d)/2;
        
        int[][] dp = new int[n][target + 1];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        int countOfSubsetHavingTargetSum = subsetTargetSum(arr, target, n - 1, dp);
        
        return countOfSubsetHavingTargetSum;
    }
    
    int subsetTargetSum(int[] nums, int target, int index, int[][] dp){
        if(index == 0){
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || nums[0] == target) return 1;
            return 0;
        }
        
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        
        int notTakenAnsCount = subsetTargetSum(nums, target, index - 1, dp);
        
        int takenAnsCount = 0;
        
        if(target >= nums[index]){
            takenAnsCount = subsetTargetSum(nums, target - nums[index], index - 1, dp);
        }
        
        dp[index][target] = notTakenAnsCount + takenAnsCount;
        
        return dp[index][target];
    }
}
