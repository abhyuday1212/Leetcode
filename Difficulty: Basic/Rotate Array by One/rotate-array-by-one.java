//{ Driver Code Starts
// // Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution ob = new Solution();
            ob.rotate(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// // User function Template for Java

class Solution {
    public void rotate(int[] arr) {  

        int n = arr.length -1; //n points to index
        int temp = arr[n]; //Add the last value into temp

        for (int i = 0; i < n; i++) {
            // Start from last
            arr[n-i] = arr[n-i-1];
        }

        arr[0] = temp; 
        
    }
}