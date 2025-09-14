class Solution {
    int[] dr = { -1, 0, 1, 0 };
    int[] dc = { 0, -1, 0, 1 };

    // TC: O(M * N)

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return ans;
        }

        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        // DFS logic
        for (int k = 0; k < col; k++) {
            dfsTraversal(heights, 0, k, Integer.MIN_VALUE, pacific);
            dfsTraversal(heights, row - 1, k, Integer.MIN_VALUE, atlantic);
        }
        for (int k = 0; k < row; k++) {
            dfsTraversal(heights, k, 0, Integer.MIN_VALUE, pacific);
            dfsTraversal(heights, k, col - 1, Integer.MIN_VALUE, atlantic);
        }

        // prepare ans 
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public void dfsTraversal(int[][] heights, int row, int col, int prevHt, boolean[][] ocean) {
        int m = heights.length;
        int n = heights[0].length;

        // check if it reaches pacific ocean
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }

        // based on prev ht
        if (heights[row][col] < prevHt || ocean[row][col])
            return;

        ocean[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextR = dr[i] + row;
            int nextC = dc[i] + col;

            dfsTraversal(heights, nextR, nextC, heights[row][col], ocean);
        }
    }
}