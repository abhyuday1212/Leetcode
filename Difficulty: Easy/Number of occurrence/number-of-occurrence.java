//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
    if(arr.length == 0) return 0;


        int floorVal = floor(arr, target);
        int ceilVal = ceil(arr, target);
        
        if(floorVal == -1 || ceilVal == -1) return 0;
        
        return (floorVal - ceilVal) + 1;
    }
    
    
    public int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

         if (target < arr[0]) {
            return -1; // No floor exists
        }

        int floor = -1;

        List<Integer> list1 = new ArrayList<>();

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                list1.add(arr[mid]);
            }

            if (arr[mid] <= target) {
                floor = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if(list1.isEmpty()) return -1;

        return floor;
    }

    public int ceil(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        

        if (target > arr[end]) {
            return -1; // No ceil exists
        }

        List<Integer> list1 = new ArrayList<>();

        int ceil = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                list1.add(arr[mid]);
            }

            if (arr[mid] >= target) {
                ceil = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if(list1.isEmpty()) return -1;

        return ceil;
    }
}
