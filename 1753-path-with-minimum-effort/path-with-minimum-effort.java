class Solution {
    class Pair{
        int diff; // difference between prev row and curColumns
        int row;
        int col;

        public Pair(int diff, int row, int col){
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[] src = {0, 0};
        int[] destination = {m-1, n - 1};

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.diff - y.diff);// we can take q also
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // put the first element that is src in the q and the diffance
        dist[src[0]][src[1]] = Integer.MAX_VALUE;
        pq.add(new Pair(0, src[0], src[1]));


        // now iterate the pq
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int curdiff = p.diff;
            int curRow = p.row;
            int curCol = p.col;

            //check weather it reached destination
            if(curRow == m-1 && curCol == n - 1){
                // you reached the destination
                return curdiff;
            }

            // traverse the next nodes

            for(int i = 0; i < 4; i++){
                int nextR = curRow + dr[i];
                int nextC = curCol + dc[i];

                if(nextR >= 0 && nextR < m && nextC >= 0 && nextC < n){
                    int difference = Math.abs(heights[curRow][curCol] - heights[nextR][nextC]);
                    int newEffort = Math.max(difference, curdiff);

                    if(newEffort < dist[nextR][nextC]){
                        dist[nextR][nextC] = newEffort;
                        pq.add(new Pair(newEffort, nextR, nextC));
                    }
                }
            }
        }

        return -1;
    }
}