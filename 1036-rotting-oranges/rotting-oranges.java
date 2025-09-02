class Solution {
    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];

        int freshOranges = 0;

        // q to store rotten organges
        Queue<Pair> q = new LinkedList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 2) {
                    q.add(new Pair(row, col));
                } else if (grid[row][col] == 1) {
                    freshOranges++;
                }
            }
        }

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        int timeRequired = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            boolean infectedThisMinute = false;

            for (int i = 0; i < qSize; i++) {
                Pair p = q.poll();
                int curRow = p.row;
                int curCol = p.col;
                isVisited[curRow][curCol] = true;

                for (int k = 0; k < 4; k++) {
                    int nextRow = curRow + dr[k];
                    int nextCol = curCol + dc[k];

                    // putting the neighbours in q
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !isVisited[nextRow][nextCol]
                            && grid[nextRow][nextCol] == 1) {
                        // infect it
                        grid[nextRow][nextCol] = 2;
                        freshOranges--;
                        isVisited[nextRow][nextCol] = true;
                        q.add(new Pair(nextRow, nextCol));
                        infectedThisMinute = true;
                    }
                }
            }
            if (infectedThisMinute) {
                timeRequired++;
            }
        }

        return freshOranges == 0 ? timeRequired : -1;
    }
}