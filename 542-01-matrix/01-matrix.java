class Solution {
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

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] distanceMat = new int[m][n];
        boolean[][] isVisited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
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

    // TC: O(m x n)(m x n)
    // private class Pair {
    //     int parentNode;
    //     int distance;

    //     public Pair(int parentNode, int distance) {
    //         this.parentNode = parentNode;
    //         this.distance = distance;
    //     }
    // }

    // public int[][] updateMatrix(int[][] mat) {
    //     int m = mat.length;
    //     int n = mat[0].length;
    //     int v = m * n;

    //     ArrayList<ArrayList<Integer>> adj = getAdjacencyList(mat);

    //     int[][] distanceMat = new int[m][n];

    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (mat[i][j] == 0) {
    //                 distanceMat[i][j] = 0;
    //             } else {
    //                 // do the bfs traversal to find the nearest 0;
    //                 int distance = findDistanceBybfs(i, j, adj, mat);
    //                 // After rotten oranges, this is the second question, this is because in rotten oranges also we had to traverse level wise, in this also we have to traverse level wise but it is not needed because of the increase in time complexity
    //                 distanceMat[i][j] = distance;
    //             }
    //         }
    //     }

    //     return distanceMat;
    // }

    // public int findDistanceBybfs(int startRow, int startCol, ArrayList<ArrayList<Integer>> adj, int[][] mat) {
    //     int m = mat.length;
    //     int n = mat[0].length;
    //     int startNode = startRow * n + startCol;

    //     Queue<Pair> q = new LinkedList<>();
    //     q.add(new Pair(startNode, 0));

    //     boolean[] visited = new boolean[m * n];
    //     visited[startNode] = true;

    //     while (!q.isEmpty()) {
    //         Pair curPair = q.poll();
    //         int curNode = curPair.parentNode;
    //         int distance = curPair.distance;

    //         // converting 1D into 2d
    //         int row = curNode / n;
    //         int col = curNode % n;

    //         if(mat[row][col] == 0){
    //             return distance;
    //         }

    //         for(int adjNode: adj.get(curNode)){
    //             if(!visited[adjNode]){
    //                 visited[adjNode] = true;
    //                 q.add(new Pair(adjNode, distance + 1));
    //             }
    //         }
    //     }

    //     // This should ideally not be reached in a valid grid with at least one 0
    //     return Integer.MAX_VALUE;
    // }

    // public ArrayList<ArrayList<Integer>> getAdjacencyList(int[][] mat) {
    //     int m = mat.length;
    //     int n = mat[0].length;
    //     int v = m * n;

    //     ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
    //     for (int i = 0; i < v; i++) {
    //         adj.add(new ArrayList<>());
    //     }

    //     int[] dr = { -1, 1, 0, 0 };
    //     int[] dc = { 0, 0, -1, 1 };

    //     for (int row = 0; row < m; row++) {
    //         for (int col = 0; col < n; col++) {
    //             int curNode = row * n + col;

    //             for (int k = 0; k < 4; k++) {
    //                 int newRow = dr[k] + row;
    //                 int newCol = dc[k] + col;

    //                 if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
    //                     int neighbourNode = newRow * n + newCol;
    //                     adj.get(curNode).add(neighbourNode);
    //                 }
    //             }
    //         }
    //     }

    //     return adj;
    // }
}