//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    
    static class Meeting {
        int id;
        int startTime;
        int endTime;
        
        public Meeting(int id, int startTime, int endTime){
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    
    public int maxMeetings(int start[], int end[]) {
        // put the elements with start and end time into the array
        int n = end.length;
        Meeting[] meets = new Meeting[n];
        
        for(int i = 0; i < n; i++){
            meets[i] = new Meeting(i , start[i], end[i]);
        }
        
        // Sort the Array on the basis of the end Date
        
        Arrays.sort(meets, (a, b) -> a.endTime - b.endTime);
        
        // since the arrays are sorted then now we can simply compare
        int count =0;
        int insertedEndTime = -1;
        
        for(int i = 0; i < n; i++){
            if(insertedEndTime < meets[i].startTime){
                // System.out.println(meets[i].id);
                
                insertedEndTime = meets[i].endTime; 
                count++;
            }
        }
        
        return count;
    }
}
