class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0) && dfsTraversal(board, word, isVisited, i, j, 1)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfsTraversal(char[][] board, String word, boolean[][] isVisited, int row, int col, int index){
        if(index >= word.length()){
            return true;
        }

        int m = board.length;
        int n = board[0].length;

        isVisited[row][col] = true;

        for(int k = 0; k < 4; k++){
            int nextR = row + dr[k];
            int nextC = col + dc[k];

            if(nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !isVisited[nextR][nextC] && board[nextR][nextC] == word.charAt(index) && dfsTraversal(board, word, isVisited, nextR, nextC, index + 1)){
                // System.out.println("Found char: " + word.charAt(index) + " " + nextR + " " + nextC);
                isVisited[nextR][nextC] = true;
                return true;
            }
        }

        isVisited[row][col] = false;
        return false;
    }
}