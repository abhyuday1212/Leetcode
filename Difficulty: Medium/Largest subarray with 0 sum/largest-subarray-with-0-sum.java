class Solution {
    int maxLength(int arr[]) {
       int n = arr.length;
       HashMap<Integer, Integer> mp = new HashMap<>();
       
       int prefixSum = 0;
       
       int maxLen = 0;
       
       for(int i = 0; i < n; i++){
           prefixSum += arr[i];
            
           if(prefixSum == 0){
               maxLen = Math.max(maxLen, i + 1);
           }
           else{
               if(mp.containsKey(prefixSum)){
                   maxLen = Math.max(maxLen, i - mp.get(prefixSum));
               }
               else{
                   // dont put the current element index if it is already present 
                   // as it will override
                   mp.put(prefixSum, i);
               }
               
           }
       }
       
       return maxLen;
    }
}