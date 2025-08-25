class Solution {
    public int getMin(int n) {
        int[] currency = {10, 5, 2, 1};
        
        int count = 0;
        
        int totalCurSum = 0;
        int l = 0, n1 = currency.length;
        
        while(l < n1){
            while(totalCurSum + currency[l] <= n){
                totalCurSum += currency[l];
                count++;
            }
            
            
            l++;
        }
        
        return count;
    }
}
