
class Solution {
    //better M-1:
    // run two for loop and find all the subarrays and check if there sum is equal to target or not
    
    //optimal M-3: Transpose of a matrix and then reversing each row


    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //Transpose of a matrix

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j);
            }
        }

        // now perform reverse operation for each row
        for (int i = 0; i < n; i++) {
            reverseArray(matrix[i]);
        }

    }

    public void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public void reverseArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
}