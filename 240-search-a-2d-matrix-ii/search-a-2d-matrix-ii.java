class Solution {
    // Optimal Approach: transform the 2d Array such that it is intersecting at the corner point, it is increasing from one end and decreasing on the other end;

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1;

        while(row < m && col >= 0){
            //matrix[row][col] is the corner most index of the matrix at top right
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target) row++; // since element is bigger than move down to search in higher search space

            else col--; //move leftword as we have choosed the matrix[row][col] as the mid element
        }

        return false;
    }
}