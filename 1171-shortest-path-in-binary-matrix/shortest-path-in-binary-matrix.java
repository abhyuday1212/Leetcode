class Solution {
    class Pair {
        int dist;
        int row;
        int col;

        public Pair(int dist, int row, int col) {
            this.dist = dist;
            this.row = row;
            this.col = col;
        }

    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return -1;

        int[][] dist = new int[m][n];

        //---Fill the dist array with Max val
        for (int u = 0; u < m; u++) {
            for (int v = 0; v < n; v++) {
                dist[u][v] = Integer.MAX_VALUE;
            }
        }

        // assign the src node dist = 0; 
        dist[0][0] = 1;
        pq.add(new Pair(1, 0, 0));

        // For 4 Directions
        // int[] dr = { -1, 1, 0, 0 };
        // int[] dc = { 0, 0, -1, 1 };

        int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int curDist = p.dist;
            int curRow = p.row;
            int curCol = p.col;

            if (curRow == m - 1 && curCol == n - 1) {
                return curDist;
            }

            // iterate the remaining 4 direction to see rest
            for (int i = 0; i < 8; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 0
                        && curDist + 1 < dist[nextRow][nextCol]) {

                    dist[nextRow][nextCol] = curDist + 1;
                    pq.add(new Pair(curDist + 1, nextRow, nextCol));
                }
            }
        }

        return -1;
    }
}