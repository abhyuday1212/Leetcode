//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int q = sc.nextInt();
      int ind[]=new int[q]; 
      for(int i=0;i<q;i++) ind[i]=sc.nextInt();
      Solution obj = new Solution();
      int ans[] = obj.count_NGEs(n,a,q,ind);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
      int[] ans = new int[indices.length];
      
      for(int i= 0; i < indices.length; i++ ){
          ans[i] = countNextGreaterElement(indices[i], arr);
        }
        
        return ans;
    }
    
    
     public static int countNextGreaterElement(int index, int[] arr) {
        // Stack<Integer> st = new Stack<>();
        int count = 0;
        int currElem = arr[index];

        for(int i = arr.length -1; index <= i; i--){
            // The next greater element is the top of the stack if available; otherwise, -1.
           if(currElem < arr[i]){
               count++;
           }
           
        }
 
        return count;
    }
}
     