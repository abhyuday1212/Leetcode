class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int lastEndTime = intervals[0][1];

        for (int i = 1; i < n; i++) {
            // if lastEndTime < startEndTime => Non overlapping interval
            int curStartTime = intervals[i][0];
            int curEndTime = intervals[i][1];
            if (lastEndTime <= curStartTime) { // "=" condition is for this question only
                count++;
                lastEndTime = curEndTime;
            }
        }

        return n - count;
    }
}