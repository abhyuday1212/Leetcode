// User function Template for Java

class Solution {
    class Pair{
        int dist;
        int row;
        int col;
        
        public Pair(int dist, int row, int col){
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
        
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dist = new int[m][n];
        
        //---Fill the dist array with Max val
        for(int u = 0; u < m; u++){
            for(int v = 0; v < n; v++){
                dist[u][v] = Integer.MAX_VALUE;
            }
        }
        
        // assign the src node dist = 0;
        dist[source[0]][source[1]] = 0;
        
        pq.add(new Pair(0, source[0], source[1]));
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            
            int curDist = p.dist;
            int curRow = p.row;
            int curCol = p.col;
            
            if (curRow == destination[0] && curCol == destination[1]) {
                return curDist;
            }
            
            // iterate the remaining 4 direction to see rest
            for(int i = 0; i < 4; i++){
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                
                if(nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1 && curDist + 1 < dist[nextRow][nextCol] ){
                    dist[nextRow][nextCol] = curDist + 1;
                    
                    // if(nextRow == destination[0] && nextCol == destination[1]){
                    //     return curDist + 1;
                    // }
                    pq.add(new Pair(curDist + 1, nextRow, nextCol));
                }
                
                // if(dist[destination[0]][destination[1]] != Integer.MAX_VALUE){
                //     break;
                // }
            }
        }
        
        return -1;
        
        
    }
}
