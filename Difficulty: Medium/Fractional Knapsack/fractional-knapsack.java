//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] valueInput = br.readLine().trim().split(" ");
            int[] values = new int[valueInput.length];
            for (int i = 0; i < valueInput.length; i++) {
                values[i] = Integer.parseInt(valueInput[i]);
            }
            String[] weightInput = br.readLine().trim().split(" ");
            int[] weights = new int[weightInput.length];
            for (int i = 0; i < weightInput.length; i++) {
                weights[i] = Integer.parseInt(weightInput[i]);
            }
            int w = Integer.parseInt(br.readLine().trim());
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Knapsack{
        int id;
        int val;
        int wt;
        double valByWt;
        
        public Knapsack(int id, int val, int wt, double valByWt){
            this.id = id;
            this.val = val;
            this.wt = wt;
            this.valByWt = valByWt;
        }
    }
    
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        Knapsack[] kp = new Knapsack[n];
        
        for(int i = 0; i < n ; i++){
            kp[i] = new Knapsack(i, values[i], weights[i], (double)values[i]/weights[i]);
        }
        
        // sort on the basis of valByWt
        Arrays.sort(kp, (a, b) -> Double.compare(b.valByWt, a.valByWt));
        
        double totalVal = 0;
        int remainingWt = W;
        
        for(int i = 0; i < n; i++){
            if(remainingWt <= 0){
                break;
            }
            else if(remainingWt >= kp[i].wt){
                double cur = (double)kp[i].val;
                totalVal += cur;
                remainingWt -=  (double)kp[i].wt;
            }
            else{
                 // fractional case
                double cur = kp[i].valByWt * (double)remainingWt;
                totalVal += cur;
                remainingWt = 0;
            }
        }
        
        return totalVal;
    }
}