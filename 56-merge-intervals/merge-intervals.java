class Solution {
    public int[][] merge(int[][] intervals) {
        // similar to insert interval
        int n = intervals.length;

        // sort on the basis of start index
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();

        // Add the first interval.
        ans.add(new int[] { intervals[0][0], intervals[0][1] });
 
        for (int i = 1; i < n; i++) {
            int[] lastInterval = ans.get(ans.size() - 1);
            
            // Check if there is an overlap.
            if (lastInterval[1] >= intervals[i][0]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            } else {
                // no overlap
                ans.add(new int[] { intervals[i][0], intervals[i][1] });
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}