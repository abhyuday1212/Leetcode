class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        int newStart = newInterval[0];
        int newEnd = newInterval[1];


        List<int[]> ans = new ArrayList<>();

        int i = 0;

        // left part
        while (i < n && intervals[i][1] < newStart) {
            // interval ka ending < newInterval ka start
            ans.add(intervals[i]);
            i++;
        }

        // middle part -> collision happens
        while (i < n && intervals[i][0] <= newEnd) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        ans.add(newInterval);

        // explore the right part
        //  newEnd < curStart
        while (i < n && newEnd < intervals[i][0]) {
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}