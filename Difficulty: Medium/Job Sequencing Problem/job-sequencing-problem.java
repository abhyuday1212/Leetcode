//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {
    static class Job {
    int id;
    int deadline;
    int profit;
    
    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        
        // Create jobs array
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            // You can be Using i+1 as job id if you want them 1-indexed.
            jobs[i] = new Job(i+1, deadline[i], profit[i]);
        }
        
        // Sort jobs in descending order based on profit
        // Max Profit sbse phle
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
    
    
        // Determine the max deadline first, fir create an array
        int maxDeadline = 0;
        
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }
        
        //Create a array to store the ids,
        int[] slots = new int[maxDeadline + 1];
        
        Arrays.fill(slots, -1);
        
        // now we have the jobs array and sorted it based on the profit
        // we should iterate the jobs array and put one element one by one
        
        int totalJobs = 0, totalProfit = 0;
        
        for(int i = 0; i < n ; i++){
            // fill in the job ids
            for(int j = jobs[i].deadline; j > 0; j--){
                if(slots[j] == -1){
                    // System.out.println(jobs[i].id);
                    // put the id into the array
                    slots[j] = jobs[i].id;
                    totalJobs++;
                    totalProfit += jobs[i].profit;
                    
                    // After filling a value, mmediatel break;
                    break;
                }
                
                //else keep moving towards left untill you are at 0 index
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(totalJobs);
        list.add(totalProfit);
        
        return list;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends