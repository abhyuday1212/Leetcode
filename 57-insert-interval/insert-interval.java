class Solution {
    // TC: O(n)
    // Sc: O(n)

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        List<int[]> ans = new ArrayList<>();

        int i = 0;

        // curEnd < newStart
        while (i < n && intervals[i][1] < newStart) {
            ans.add(intervals[i]);
            i++;
        }

        // collision part
        while (i < n && intervals[i][0] <= newEnd) {
            System.out.println("intervals Start: " + intervals[i][0]);
            System.out.println("new Start: " + newStart);


            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);

            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);

        //  newEnd < curStart
        while (i < n && newEnd < intervals[i][0]) {
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}