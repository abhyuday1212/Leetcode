class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, ans, n);
        return ans;
    }

    public void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> cur = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            cur.add(new String(board[i]));
        }
        return cur;
    }

    // TC: O(3n) => Brut
    public boolean isSafe(int row, int col, char[][] board, int n) {
        int dupRow = row;
        int dupCol = col;

        // moving upword
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        // moving left
        row = dupRow;
        col = dupCol;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }

        // moving downword
        row = dupRow;
        col = dupCol;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }

        return true;
    }
}