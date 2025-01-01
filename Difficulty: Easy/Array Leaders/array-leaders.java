//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            List<Integer> result = new Solution().leaders(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();    // Ensure new line after each test case output
                System.out.println("~"); // Ensure new line after each test case output
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    
    //Optima:
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int maxVal = Integer.MIN_VALUE;
        
        for (int i = n-1 ; i>= 0; i--){
            
            if(arr[i] >= maxVal ){
                list.add(arr[i]);
            }
            
            maxVal = Math.max(maxVal, arr[i]);
        }
        
        Collections.reverse(list);
        
        return list;
        
    }
    
    
    // brute Force approach: we use two for loop to calculate the list
    // static ArrayList<Integer> leaders(int arr[]) {
    //     // brute Force approach: we use two for loop to calculate the list

    //     ArrayList<Integer> list = new ArrayList<>();
    //     int n = arr.length;
    //     int flag = 0;

    //     if (arr.length == 0) return new ArrayList<>();

    //     else if (arr.length == 1) {
    //         list.add(arr[0]);
    //         return list;
    //     }

    //     else if (arr.length == 2) {
    //         if (arr[0] != arr[1] && arr[0] > arr[1]) {
    //             list.add(arr[0]);
    //             list.add(arr[1]);
    //         } 
            
    //         else if(arr[0] != arr[1] && arr[0] < arr[1] || arr[0] == arr[1]) {
    //             list.add(arr[1]);
    //         }
             
            
    //         else return new ArrayList<>();
    //     }

    //     for (int i = 0; i < n; i++) {

    //         for (int j = i + 1; j < n; j++) {
    //             if (arr[i] >= arr[j]) {
    //                 // the current element is a Leader
    //                 flag = 1;
    //             } else {
    //                 flag = 0;
    //                 break;
    //             }
    //         }

    //         if (flag == 1) {
    //             list.add(arr[i]);
    //         }
    //     }

    //     return list;
        
    // }
    
}
