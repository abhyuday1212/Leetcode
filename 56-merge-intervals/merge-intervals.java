class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by start

        List<int[]> ans = new ArrayList<>();
        int[] current = intervals[0]; 

        for(int i = 1; i < n; i++){
            // overlap -> merge
            if(intervals[i][0] <= current[1]){
                // pichle ka end bda h current k start se
                current[1] = Math.max(intervals[i][1], current[1]);
            }
            else{
                // no overlap -> push current and reset
                ans.add(current);
                current = intervals[i];
            }
        }

        ans.add(current);

        return ans.toArray(new int[ans.size()][]);
    }
}