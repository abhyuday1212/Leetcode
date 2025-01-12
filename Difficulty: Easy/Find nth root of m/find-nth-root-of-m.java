//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthRoot(n, m);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int nthRoot(int n, int m) {
       if(m == 0 || m == 1) return m;
       
       int start = 1;
       int end = m;
       
       int tempAns = -1;
       
       while(start <= end){
           int mid = start + (end - start)/2;
           
           int power = calculatePow(mid, n);
           
           if(power == m){
               return mid;
           }
           else if(power< m){
               start = mid + 1;
           }
           else{
               end = mid - 1;
           }
       }
       
       return tempAns;
    }
    
    public int calculatePow(int x, int n){
        if(n== 0) return 1;
        
        int half = calculatePow(x, n/2);
        
        if(n%2 == 0) return half*half;
        else return half*half*x;
    }
}