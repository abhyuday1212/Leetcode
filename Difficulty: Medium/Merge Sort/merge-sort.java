class Solution {

    void mergeSort(int arr[], int l, int r) {
        if(l >= r ) return;
        
        int mid = l + (r - l)/2;
        
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    
    void merge(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid + 1;
        
        int[] temp = new int[high - low + 1];
        
        int index = 0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[index] = arr[left];
                left++;
            }
            else{
                temp[index] = arr[right];
                right++;
            }
            index++;
        }
        
        
        while(left <= mid){
            temp[index] = arr[left];
            left++;
            index++;
        }
        
        while(right <= high){
            temp[index] = arr[right];
            right++;
            index++;
        }
        
        for(int i = 0; i < temp.length; i++){
            arr[low + i] = temp[i];
        }
    }
}