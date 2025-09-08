class Solution {
    private class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};


    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] isVisited = new boolean[m][n];
        int maxArea = 0;

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(!isVisited[row][col] && grid[row][col] == 1){
                    maxArea = Math.max(1 + bfsTraversal(row, col, isVisited, grid), maxArea);
                }
            }
        }

        return maxArea;
    }

    public int bfsTraversal(int row, int col, boolean[][] isVisited, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int area = 0;
        q.add(new Pair(row, col));
        isVisited[row][col] = true;

        while(!q.isEmpty()){
            Pair curPair = q.poll();
            int curRow = curPair.row;
            int curCol = curPair.col;
            
            for(int i = 0; i < 4; i++){
                int nextR = dr[i] + curRow;
                int nextC = dc[i] + curCol;

                if(nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !isVisited[nextR][nextC] && grid[nextR][nextC] == 1 ){
                    area++;
                    isVisited[nextR][nextC] = true;
                    q.add(new Pair(nextR, nextC));
                }
            }
        }

        return area;
    }
}