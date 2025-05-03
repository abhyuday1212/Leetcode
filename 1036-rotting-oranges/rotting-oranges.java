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

        int timeTaken = 0;
        int freshOrange = 0;

        boolean isVisited[][] = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (!isVisited[row][col] && grid[row][col] == 2) {
                    q.add(new Pair(row, col));
                    isVisited[row][col] = true;
                } else if (grid[row][col] == 1) {
                    freshOrange++;
                } else {
                    isVisited[row][col] = true;
                }
            }
        }

        // find the adjacent elements
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!q.isEmpty() && freshOrange > 0) {
            int qSize = q.size();
            boolean infectedThisMinute = false;

            for (int i = 0; i < qSize; i++) {
                Pair curPair = q.poll();
                int curRow = curPair.row;
                int curCol = curPair.col;

                isVisited[curRow][curCol] = true;

                for (int k = 0; k < 4; k++) {
                    int nextRow = curRow + dr[k];
                    int nextCol = curCol + dc[k];

                    // putting the neighbours in q
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !isVisited[nextRow][nextCol]
                            && grid[nextRow][nextCol] == 1) {
                        // infect it
                        grid[nextRow][nextCol] = 2;
                        freshOrange--;
                        isVisited[nextRow][nextCol] = true;
                        q.add(new Pair(nextRow, nextCol));
                        infectedThisMinute = true;
                    }
                }
            }

            if (infectedThisMinute) {
                timeTaken++;
            }

        }

        return (freshOrange == 0 ? timeTaken : -1);
    }
}