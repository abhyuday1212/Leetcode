class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

         int[] row = new int[n];
         Arrays.fill(row, 1);

         int[] col = new int[m];
         Arrays.fill(col, 1);

        for(int i =0; i<n ; i++){
            for(int j = 0; j< m; j++){
                if(matrix[i][j] == 0){
                    row[i] =0;
                    col[j] = 0;
                }
            }
            
        }


        // Now from the values of row and col array, modify the matrix
        for(int i = 0; i < n ; i++ ){
            for(int j = 0; j < m; j++){
                if(row[i] == 0 || col[j] == 0){
                    matrix[i][j] =0;
                }
            }
        }
    }
}