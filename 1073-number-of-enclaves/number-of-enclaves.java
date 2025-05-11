class Solution {
    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };


    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        boolean[][] isVisited = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            // top row
            if (!isVisited[0][i] && grid[0][i] == 1) {
                bfsTraversal(0, i, isVisited, grid);
            }

            //last row
            if (!isVisited[m - 1][i] && grid[m - 1][i] == 1) {
                bfsTraversal(m - 1, i, isVisited, grid);
            }
        }

        for (int j = 0; j < m; j++) {
            // top col
            if (!isVisited[j][0] && grid[j][0] == 1) {
                bfsTraversal(j, 0, isVisited, grid);
            }

            //last col
            if (!isVisited[j][n - 1] && grid[j][n - 1] == 1) {
                bfsTraversal(j, n - 1, isVisited, grid);
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (!isVisited[row][col] && grid[row][col] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public void bfsTraversal(int row, int col, boolean[][] isVisited, int[][] grid) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row, col));

        int m = grid.length; // row length
        int n = grid[row].length; // col length

        while (!q.isEmpty()) {
            Pair curPair = q.poll();

            int curRow = curPair.row;
            int curCol = curPair.col;
            isVisited[curRow][curCol] = true;

            // find the connected neighbours
            for (int i = 0; i < 4; i++) {
                int nextRow = dr[i] + curRow;
                int nextCol = dc[i] + curCol;

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !isVisited[nextRow][nextCol]
                        && grid[nextRow][nextCol] == 1) {
                    isVisited[nextRow][nextCol] = true;
                    q.add(new Pair(nextRow, nextCol));
                }
            }
        }
    }
}