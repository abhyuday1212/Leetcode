class Solution {
    public int josephus(int n, int k) {
        // code here
        boolean[] arr = new boolean[n + 1];
        
        int startIndex = k % n;
          
        if (startIndex == 0) {
            startIndex = n;
        }
            
        return recursiveHelper(arr, k, startIndex, n);
    }
    
    public int recursiveHelper(boolean[] arr, int k, int index, int remaining){
        int n = arr.length - 1;
        
        if(remaining == 1){
            for (int i = 1; i <= n; i++) {
                if (!arr[i]) {
                    return i;
                }
                
            }
        }
  
        
        // standing at killable person index
        
        arr[index] = true;
        
        int nextIndex = index;
        
        // the nextIndex is being determined without counting that the mid elements could be deleted
        int cnt = 0;
        
        while(cnt < k){
            nextIndex++;
            
            if(nextIndex > n){
                nextIndex = 1;
            }
            
            if(!arr[nextIndex]){
                cnt++;
            }
        }
        
        
        
        
        // System.out.println("Killing index: " +  index);
        // System.out.println("Next Killing index: " +  nextIndex);
        
        
        return recursiveHelper(arr, k, nextIndex, remaining - 1);
    }
}