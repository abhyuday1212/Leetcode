// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        
        int maxLen = 0;
        
        long prefixSum = 0;
        
        // prefix Sum, index
        HashMap<Long, Integer> mp = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            prefixSum += arr[i];
            // System.out.println("Sum: " + prefixSum);
            
            if(prefixSum == k){
                maxLen = Math.max(maxLen, i + 1);
            }
            else if(!mp.isEmpty() && mp.containsKey(prefixSum - k)){
                
                maxLen = Math.max(maxLen, i - mp.get(prefixSum - k));
            }
            
            // for negatives, you have to find the element which contains the prefix sum to the extreme left
            // for this you need to not put the elements as we need the longest subarray
            if(!mp.containsKey(prefixSum)){
                mp.put(prefixSum, i);
            }
        }
        
        return maxLen;
    }
}
