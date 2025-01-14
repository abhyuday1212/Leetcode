class Solution {
    // Optimal Approach: transform the 2d Array into a oneD array
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0;
        int end = n * m - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target)
                return true;

            else if (matrix[row][col] < target)
                start = mid + 1;
            else
                end = mid - 1;

        }
        return false;
    }

    // Better Approach
    // public boolean searchMatrix(int[][] matrix, int target) {

    // for (int i = 0; i < matrix.length; i++) {
    // int m = matrix[i].length;

    // if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
    // return binarySearch(matrix[i], target);
    // }
    // }

    // return false;
    // }

    // public boolean binarySearch(int[] arr, int target) {
    // int start = 0;
    // int end = arr.length - 1;

    // while (start <= end) {
    // int mid = start + (end - start) / 2;

    // if (arr[mid] == target) {
    // return true;
    // } else if (arr[mid] > target) {
    // end = mid - 1;
    // } else {
    // start = mid + 1;
    // }
    // }

    // return false;
    // }
}