class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // horizontal traversal
        for (int i = 0; i < n; i++) {
            Set<Character> st = new HashSet<>();
            for (int j = 0; j < m; j++) {
                char cur = board[i][j];
                if (cur != '.') {
                    if (st.contains(cur)) return false;
                    st.add(cur);
                }
            }
        }

        // vertical traversal
        for (int col = 0; col < m; col++) {
            Set<Character> st = new HashSet<>();
            for (int row = 0; row < n; row++) {
                char cur = board[row][col];
                if (cur != '.') {
                    if (st.contains(cur)) return false;
                    st.add(cur);
                }
            }
        }

        // 3x3 traversal using recursion
        return checkSubBoxes(board, 0, 0);
    }

    // Recursive function to check each 3x3 box
    private boolean checkSubBoxes(char[][] board, int row, int col) {
        if (row >= 9) return true; // all boxes checked

        Set<Character> st = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char cur = board[i][j];
                if (cur != '.') {
                    if (st.contains(cur)) return false;
                    st.add(cur);
                }
            }
        }

        if (col + 3 < 9) {
            return checkSubBoxes(board, row, col + 3);
        } else {
            return checkSubBoxes(board, row + 3, 0);
        }
    }
}