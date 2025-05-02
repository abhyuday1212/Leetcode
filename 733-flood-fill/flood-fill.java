class Solution {
    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        boolean[][] isVisited = new boolean[m][n];

        int lookUpValue = image[sr][sc];

        for (int row = sr; row < m; row++) {

            for (int col = sc; col < n; col++) {
                if (!isVisited[row][col] && image[row][col] == lookUpValue) {
                    bfsTraversal(row, col, isVisited, image, lookUpValue, color);

                }
                if (image[row][col] != lookUpValue) {
                    break;
                }
            }
            break;
        }

        return image;
    }

    public void bfsTraversal(int row, int col, boolean[][] isVisited, int[][] image, int lookUpValue, int color) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row, col));

        int m = image.length; // row length
        int n = image[row].length; // col length

        while (!q.isEmpty()) {
            Pair curPair = q.poll();

            int curRow = curPair.row;
            int curCol = curPair.col;

            image[curRow][curCol] = color;
            // System.out.println("Processing Pair:" + curRow + " & " + curCol);

            // find the connected neighbours
            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };

            for (int i = 0; i < 4; i++) {
                int nextRow = dr[i] + curRow;
                int nextCol = dc[i] + curCol;

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !isVisited[nextRow][nextCol]
                        && image[nextRow][nextCol] == lookUpValue) {
                    // System.out.println("Pairs Added: " + nextRow + " & " + nextCol);

                    // image[nextRow][nextCol] = color;
                    isVisited[nextRow][nextCol] = true;
                    q.add(new Pair(nextRow, nextCol));
                }
            }
        }
    }
}