//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    int floorSqrt(int n) {
       if(n == 0 || n == 1) return n;
       
       int start = 1;
       int end = n;
       
       int tempAns = 1;
       
       while(start <= end){
           int mid = start + (end - start)/2;
           
        //   if(mid == n){
        //       return mid;
        //   }
           
           if(mid*mid<= n){
               tempAns = mid;
               start = mid + 1;
           }
           else{
               end = mid - 1;
           }
       }
       
       return tempAns;
    }
}
