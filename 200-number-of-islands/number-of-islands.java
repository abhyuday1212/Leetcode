class Solution {
    private class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;

        int count = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < n; row++) {
            int m = grid[row].length;

            for (int col = 0; col < m; col++) {
                // if not visited already then only visit
                if (!isVisited[row][col] && grid[row][col] == '1') {
                    // do the traversal only then and count only also
                    count++;
                    bfsTraversal(row, col, isVisited, grid);
                }
            }
        }

        return count;
    }

    public void bfsTraversal(int row, int col, boolean[][] isVisited, char[][] grid) {
        // create a loop to iterate over every node using q
        Queue<Pair> q = new LinkedList<>();
        Pair p1 = new Pair(row, col);
        q.add(p1);
        int n = grid.length;
        int m = grid[row].length;

        // how to find the neighbours
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            // pol the value of the row and col and then
            Pair curPair = q.poll();

            int curRow = curPair.row;
            int curCol = curPair.col;

            isVisited[curRow][curCol] = true;

            // traverse the neighbours
            // whome to add in the q? Ans is neighbours,

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !isVisited[nextRow][nextCol]
                        && grid[nextRow][nextCol] == '1') {

                    isVisited[nextRow][nextCol] = true;
                    q.add(new Pair(nextRow, nextCol));
                }
            }
        }

    }
}