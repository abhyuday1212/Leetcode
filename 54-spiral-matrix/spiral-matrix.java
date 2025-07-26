class Solution {
    int count = 0;
    boolean isAdd = true;

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        int r1 = 0, r2 = m - 1;
        int c1 = 0, c2 = n - 1;

        while(r1 <= r2 && c1 <= c2){
            // System.out.println("Loop Started, r1: " + r1 + " c1: " + c1);
            // traverse right
            for(int i = c1; i <= c2; i++){
                // System.out.println("Ans: " + matrix[r1][i]);
                ans.add(matrix[r1][i]);
            }
            r1++;

            // traverse down
            for(int i = r1; i <= r2; i++){
                // System.out.println("Ans: " + matrix[i][c2]);
                ans.add(matrix[i][c2]);
            }
            c2--;

            if(r1 <= r2){
                for(int i = c2; i >= c1; i--){
                    // System.out.println("Ans: " + matrix[r2][i]);
                    ans.add(matrix[r2][i]);
                }
                
                // Decrease the row
                r2--;
            }

            if(c1 <= c2){
                for(int i = r2; i >= r1; i--){
                    // System.out.println("Ans: " + matrix[i][c1]);
                    ans.add(matrix[i][c1]);
                }

                // Decrease the column
                c1++;
            }
        }

        return ans;
    }

    // Approach: 1
    // public void recursiveHelper(int[][] matrix, List<Integer> ans, boolean[][] isVisited, int m, int n, int row,
    //         int col) {
    //     if (row < 0 || col < 0 || row >= m || col >= n || isVisited[row][col]) {
    //         count++;
    //         // System.out.println("Row: " + row + "Col: " + col);
    //         return;
    //     }

    //     isVisited[row][col] = true;
    //     ans.add(matrix[row][col]);

    //     if(count == 2){
    //         isAdd = false;
    //     }

    //     if (!isAdd) {
    //         // move right
    //         col--;
    //         recursiveHelper(matrix, ans, isVisited, m, n, row, col);

    //         // move down
    //         row--;
    //         recursiveHelper(matrix, ans, isVisited, m, n, row, col);

    //         count = 0;
    //         isAdd = true;
    //     } else {
    //         // move right
    //         col += 1;
    //         recursiveHelper(matrix, ans, isVisited, m, n, row, col);

    //         col--;
    //         row+= 1;
    //         // move down
    //         recursiveHelper(matrix, ans, isVisited, m, n, row, col);
    //     }

    // }
}