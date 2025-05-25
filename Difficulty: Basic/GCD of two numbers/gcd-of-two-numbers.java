
class Solution {
    public static int gcd(int a, int b) {
        while(a > 0 && b > 0){
            if(a > b){
                a = a %b;
            }
            else{
                b = b % a;
            }
            
            if(a == 0) return b;
            if(b == 0) return a;
        }
        
        return 1;
        
    }
    
    // BRUT approach: gave TLE
    // public static int gcd(int a, int b) {
    //     int gcdVal = 1;
        
    //     int n = Math.min(a, b);
        
    //     for(int i = n; i >= 0; i--){
    //         if(a % i == 0 && b % i == 0){
    //             gcdVal = i;
    //             break;
    //         }
    //     }
        
    //     return gcdVal;
    // }
}
