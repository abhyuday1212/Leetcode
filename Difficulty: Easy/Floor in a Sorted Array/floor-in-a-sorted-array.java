//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
class Solution {

    static int findFloor(int[] arr, int k) {
        int start = 0;  //index
        int end = arr.length - 1;   //index

        // What if the target is greater than the greatest number in the array
        if (k > arr[end] || k < arr[0]) {
            return -1;
        }

        int lowerBoundAns = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;   //index

            if (arr[mid] <= k) {
                lowerBoundAns = mid;
                start = mid + 1;
            } else { //k < arr[mid]
                end = mid - 1;
            }
        }

        // Condition that will execute this code: "End" "Target" "Start", and we need the element that is just greater than the target element.
        return lowerBoundAns;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.findFloor(arr, k);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends