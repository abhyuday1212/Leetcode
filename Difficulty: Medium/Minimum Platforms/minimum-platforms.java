//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int n = arr.length;
        
        int count = 0;
        int maxCount = 0;
        
        int i = 0, j = 0;
        
        while(i < n){
            if(arr[i] <= dep[j]){
                i = i+ 1;
                count++;
            }
            else{
                // if departure is happening currently then decrease the count
                count--;
                j = j+ 1;
            }
            
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
    
    // Brut: Gave error, was not able to run the code through even GPT
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    
    // static class Train{
    //     int id;
    //     int arrTime;
    //     int depTime;
        
    //     public Train(int id, int arrTime, int depTime){
    //         this.id = id;
    //         this.arrTime = arrTime;
    //         this.depTime = depTime;
    //     }
        
    // }
    
    // static int findPlatform(int arr[], int dep[]) {
    //     int n = arr.length;
        
    //     if(n == 0) return 0;
        
    //     if(n == 1) return 1;
        
    //     Train[] tr = new Train[n];
        
    //     for (int i = 0; i < n; i++) {
    //     tr[i] = new Train(i, arr[i], dep[i]);
    // }
    // Arrays.sort(tr, (a, b) -> a.arrTime - b.arrTime);

    // int maxPlatforms = 0;

    // // 2) For each train i, compare with every other train j
    // for (int i = 0; i < n; i++) {
    //     int count = 0;

    //     for (int j = 0; j < n; j++) {
    //         if (i == j) continue;

    //         // 3) Full overlap test
    //         if (tr[j].arrTime <= tr[i].depTime
    //          && tr[j].depTime  >= tr[i].arrTime) {
    //             count++;
    //         }
    //     }

    //     // 4) Include train i itself, then update max
    //     maxPlatforms = Math.max(maxPlatforms, count + 1);
    // }

    // return maxPlatforms;
    // }
}
