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
        Job[] jb = new Job[n];
        
        int jobCount = 0;
        int totalProfit = 0;
        
        int maxDays = 0;
        
        for(int i = 0; i < n; i++){
            jb[i] = new Job(i, deadline[i], profit[i]);
            
            maxDays = Math.max(maxDays, deadline[i]);
        }
        
        int[] hash = new int[maxDays];
        Arrays.fill(hash, - 1);
        
        Arrays.sort(jb, (a, b) -> b.profit - a.profit);
        
        for(int i = 0; i < n; i++){
            for(int j = jb[i].deadline - 1; j >= 0; j--){
                if(hash[j] == -1){
                    hash[j] = jb[i].id;
                    jobCount++;
                    
                    totalProfit += jb[i].profit;
                    break;
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(jobCount);
        ans.add(totalProfit);
        
        return ans;
        
    }
}