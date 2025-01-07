//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int floor = floorOfArr(arr, x);
        int ceil = ceilOfArr(arr, x);
        
        return new int[]{floor, ceil};
    }
    
        // Floor
    public int floorOfArr(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;

        if (x < arr[0]) {
            return -1; // No floor exists
        }

        int floor = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= x) {
                // Possible floor value
                floor = arr[mid];
                start = mid + 1; // Search for a closer floor on the right
            } else {
                end = mid - 1; // Search on the left
            }
        }

        return floor;
    }
    
    // Ceil
    public int ceilOfArr(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;

        if (x > arr[arr.length - 1]) {
            return -1; // No ceil exists
        }

        int ceil = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= x) {
                // Possible ceil value
                ceil = arr[mid];
                end = mid - 1; // Search for a closer ceil on the left
            } else {
                start = mid + 1; // Search on the right
            }
        }

        return ceil;
    }
}
