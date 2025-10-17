class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        
        ArrayList<String> baseAns = new ArrayList<>();
        
        if (maze[0][0] == 0 || maze[m-1][n-1] == 0) return baseAns;
        
        boolean[][] isVisited = new boolean[m][n];
        
        StringBuilder path = new StringBuilder();
        
        findDirection(path, baseAns, maze, isVisited, 0, 0);
        
        return baseAns;
    }
    
    int[] dr = { 1, 0, 0, -1 };
    int[] dc = { 0, -1, 1, 0 };
    char[] dir = { 'D', 'L', 'R', 'U' };
    
    public void findDirection(StringBuilder path, ArrayList<String> baseAns, int[][] maze, boolean[][] isVisited, int row, int col){
        int m = maze.length;
        int n = maze[0].length;
        
        if(row == m - 1 && col == n - 1){
            // add to the base list
            baseAns.add(path.toString());
            // System.out.println("Reached Here: " + ds);
            return;
        }
        
        
        isVisited[row][col] = true;
        
        for(int i = 0; i < 4; i++){
            int nextR = row + dr[i];
            int nextC = col + dc[i];
            
            if(nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !isVisited[nextR][nextC]  && maze[nextR][nextC] == 1 ){
                path.append(dir[i]);
               
            //   System.out.println("DS: " + ds);
               findDirection(path, baseAns, maze, isVisited, nextR, nextC);
               path.deleteCharAt(path.length() - 1);
            }
        }
        
        isVisited[row][col] = false;
        
        return;
    }
}