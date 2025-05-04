//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    // Function to find distance of nearest 1 in the grid for each cell.
    
    private static class Pair {
        int row;
        int column;
        int distance;

        public Pair(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }

    public int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] distanceMat = new int[m][n];
        boolean[][] isVisited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    distanceMat[i][j] = 0;
                    isVisited[i][j] = true;
                    q.add(new Pair(i, j, distanceMat[i][j]));

                }
                // do the bfs traversal to find the nearest 0;
                // int distance = findDistanceBybfs(i, j, adj, mat);
                // After rotten oranges, this is the second question, this is because in rotten oranges also we had to traverse level wise, in this also we have to traverse level wise but it is not needed because of the increase in time complexity

            }
        }

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            Pair curPair = q.poll();

            int curRow = curPair.row;
            int curCol = curPair.column;
            int distance = curPair.distance;

            for (int k = 0; k < 4; k++) {
                int nextRow = dr[k] + curRow;
                int nextCol = dc[k] + curCol;

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !isVisited[nextRow][nextCol]) {
                    isVisited[nextRow][nextCol] = true;
                    // distanceMat[nextRow][nextCol] = distance + 1;
                    // q.offer(new Pair(nextRow, nextCol, distance + 1));
                    Pair next = new Pair(nextRow, nextCol, distance + 1);
                    distanceMat[nextRow][nextCol] = next.distance;
                    q.offer(next);
                }
            }
        }

        return distanceMat;
    }

}