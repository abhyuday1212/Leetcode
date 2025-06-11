// User function Template for Java
class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
    
    // Approach 2: DP
    int minCost(int[] height) {
        int n = height.length;
        return helper(height, n - 1);
    }    
    
    int helper(int[] height, int i){
        if(i == 0) return 0;
        
        if(dp.containsKey(i)){
            return dp.get(i);
        }
        
        int left = helper(height, i - 1) + Math.abs(height[i] - height[i - 1]);
        
        int right = Integer.MAX_VALUE;
        
        if(i > 1){
            right = helper(height, i - 2) + Math.abs(height[i] - height[i - 2]);
        }
        
        int min = Math.min(left, right);
        dp.put(i, min);
        
        return min;
    }
    
    // Approach 1 :  TLE
    // Gone from 0 -> n
    // int minCostVal = Integer.MAX_VALUE;
    
    // int minCost(int[] height) {
    //     if (height == null || height.length == 0) {
    //         return 0; 
    //     }
        
    //     minCostVal = Integer.MAX_VALUE; 
         
    //     helperFun(height, 0 , 0);
    //     return minCostVal;
    // }
    
    // void helperFun(int[] height, int i, int curPathCost){ 
    //     if (i == height.length - 1) {
    //         minCostVal = Math.min(minCostVal, curPathCost); // Use minCostVal
    //         return; // Path ends here
    //     } 
        
    //     if (i >= height.length) {
    //         return; 
    //     }

        
    //     if (i + 1 < height.length) {
    //         int costJump1 = Math.abs(height[i + 1] - height[i]);
    //         helperFun(height, i + 1, curPathCost + costJump1);
    //     }
        
    //     if (i + 2 < height.length) {
    //         int costJump2 = Math.abs(height[i + 2] - height[i]);
    //         helperFun(height, i + 2, curPathCost + costJump2);
    //     }
    // }
}