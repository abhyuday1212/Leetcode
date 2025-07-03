class Solution {
    // Total Time complexity: Nlog(N)
    // Function to sort an array using quick sort algorithm.
    // Recursive Tc: log(N)
    static void quickSort(int arr[], int low, int high) {
        if(low >= high){
            return;
        }
        int pivotIndex = partition(arr, low, high);
        
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    // Tc: O(N)
    static int partition(int arr[], int low, int high) {
        int pivotElem = arr[low]; // choose randomly
        
        int left = low;
        int right = high;
        
        while(left < right){
            while(arr[left] <= pivotElem && left <= high - 1){
                left++;
            }
            
            while(arr[right] > pivotElem && right >= low + 1){
                right--;
            }
            
            // if have not crossed
            if(left < right) swap(arr, left, right);
        }
        
        // we know the right will be at the last of the low
        swap(arr, low, right);
        return right; // return the partion index
    }
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}