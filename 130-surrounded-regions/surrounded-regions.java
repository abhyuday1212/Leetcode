class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };
    
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] isVisited = new boolean[m][n];

        // mark the visited wherever '0' are there in the boundary for rows and cols

        // Rows
        for (int i = 0; i < n; i++) {
            // first row
            if (board[0][i] == 'O' && !isVisited[0][i]) {
                // dfs and mark it as visited
                dfsTraversal(0, i, isVisited, board);
            }

            // last row
            // m is total rows, so last row will be m - 1
            if (board[m - 1][i] == 'O' && !isVisited[m - 1][i]) {
                // dfs and mark it as visited
                dfsTraversal(m - 1, i, isVisited, board);
            }
        }

        // Cols
        for (int j = 0; j < m; j++) {
            //first col
            if (board[j][0] == 'O' && !isVisited[j][0]) {
                dfsTraversal(j, 0, isVisited, board);
            }

            // last col
            if (board[j][n - 1] == 'O' && !isVisited[j][n - 1]) {
                dfsTraversal(j, n - 1, isVisited, board);
            }
        }

        for (int row = 1; row < m - 1; row++) {
            for (int col = 1; col < n - 1; col++) {
                if (board[row][col] == 'O' && !isVisited[row][col]) {
                    // System.out.println("Did DFS for " + row + " col: " + col);
                    board[row][col] = 'X';
                }
            }
        }
    }

    public void dfsTraversal(int curRow, int curCol, boolean[][] isVisited, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        isVisited[curRow][curCol] = true;

        for (int k = 0; k < 4; k++) {
            int nextRow = dr[k] + curRow;
            int nextCol = dc[k] + curCol;

            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && board[nextRow][nextCol] == 'O'
                    && !isVisited[nextRow][nextCol]) {
                dfsTraversal(nextRow, nextCol, isVisited, board);
            }
        }

    }
}