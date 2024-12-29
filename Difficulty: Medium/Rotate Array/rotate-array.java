//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int d = Integer.parseInt(in.readLine().trim()); // rotation count (key)
            int n = array.size();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = array.get(i);

            new Solution().rotateArr(arr, d); // rotating the array
            StringBuilder sb = new StringBuilder();

            // printing the elements of the array
            for (int value : arr) sb.append(value).append(" ");
            out.println(sb.toString().trim());

            out.println("~");
        }
        out.flush();
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
      // temp = {1,2}
      // Step-1: Put the elements in the temporary Array
      
      if(arr.length == 0 ){
          return;
      }
      
      if (d == arr.length){
          return; // that array will not be rotated
      }
      
      else if(d > arr.length){
          d = d% arr.length;
      }
      
      
      
      int n = arr.length; //n=5
      
      List<Integer> temp = new ArrayList<>();
      
      for(int i = 0 ; i < d; i++){
          temp.add(arr[i]);
      }
      
      // temp[] = {1,2}
      
      //Step:2-> Sice we have saved the values of initial indexes, So we can modify them as we wanted
      
      for(int i = d; i < n; i++){
          arr[i-d] = arr[i];
          // 0 = d(2)
          // 1 = 3
          // 2 = 4
          //{3,4,5,4,5}
      }
      
      
      // Step:3 -> Put back the temp arr into the original One
      // n-d = 5-2 = 3
      for(int i = n - d; i < n ; i++){
          arr[i] = temp.get(i - (n - d));     // Sice temp is a list so we cannot use this method
      }
      
    }
}