class Solution {
    public int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        long sumG = 0;
        long sumC = 0;
        
        for(int i = 0; i < n; i++){
            sumG += gas[i];
            sumC += cost[i];
        }
        
        if(sumG < sumC) return -1;
        
        int start = 0;
        int gasTank = 0;
        
        for(int i = 0; i < n; i++){
            gasTank += gas[i] - cost[i];
            
            if(gasTank < 0){
                start = i + 1;
                gasTank = 0;
            }
            // else{
            //     // if possitive hai diff, break
            //     break;
            // }
        }
        
        return start;
    }
    // public int startStation(int[] gas, int[] cost) {
    //     int n = gas.length;
    //     long total = 0;   // sum(gas) - sum(cost)
    //     long tank = 0;    // current tank while trying candidate start
    //     int start = 0;

    //     for (int i = 0; i < n; i++) {
    //         int diff = gas[i] - cost[i];
    //         total += diff;
    //         tank += diff;
    //         if (tank < 0) {
    //             start = i + 1;
    //             tank = 0;
    //         }
    //     }

    //     return (total >= 0) ? (start % n) : -1;
    // }
}