class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // 6,5 -> will be going in decreasing array
                // This may be the ans but check the left part of the array
                // That is the reason we are not using end = mid -1;
                end = mid;
            } else {
                start = mid + 1;
                // You are in the ascending part of the array
                // because we know that mid+1 element is greater than the mid element

            }

        }

        // if we exits the loop, than start == end will be pointing towards same larget
        // number because of the above two checks
        // start and end are always trying to find max element in the above two checks
        // hence when they are pointing to the same element than it must be the maximum
        // one.
        return start; // or return end as start == end;
    }
}