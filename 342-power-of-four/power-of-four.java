class Solution {
    public boolean isPowerOfFour(int n) {
        boolean ans = false;

        if(n <= 0) return false;

        while(n > 0){
            if(n == 1){
                ans = true;
                break;
            }
            else if(n% 4 != 0){
                ans = false;
                break;
            }
            else if(n/4 == 1){
                ans = true;
                break;
            }
            
            n = n/4;
        }

        return ans;
    }
}