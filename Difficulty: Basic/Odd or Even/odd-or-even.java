class Solution {
    static boolean isEven(int n) {
        if(n == 0) return false;
        
        if((n & 1) == 1){
            return false;
        }
        
        return true;
    }
}