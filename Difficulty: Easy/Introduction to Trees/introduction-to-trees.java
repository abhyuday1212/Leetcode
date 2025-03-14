//{ Driver Code Starts
// Initial Template for Java

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

            Solution obj = new Solution();
            int ans = obj.countNodes(n);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int countNodes(int i) {
    // In a binary tree, each level 𝑖
    // i can have at most 2^𝑖 nodes.This is because each node can have up to two children, leading to an exponential growth in the number of nodes per level. For example, at level 0 (the root level), there's 
    // 2^0 = 1 node
    // 2^0 = 1 node
    
    if(i <= 0 ) return 1;
    
    int maxNodes = (int) Math.pow(2, i - 1);
    
    return maxNodes;
    }
}