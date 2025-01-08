class Solution {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length == 0) return new int[]{-1,-1};


        int floorVal = floor(nums, target);
        int ceilVal = ceil(nums, target);

        return new int[] { ceilVal, floorVal };
    }

    public int floor(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

         if (target < nums[0]) {
            return -1; // No floor exists
        }

        int floor = -1;

        List<Integer> list1 = new ArrayList<>();

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                list1.add(nums[mid]);
            }

            if (nums[mid] <= target) {
                floor = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if(list1.isEmpty()) return -1;

        return floor;
    }

    public int ceil(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        

        if (target > nums[end]) {
            return -1; // No ceil exists
        }

        List<Integer> list1 = new ArrayList<>();

        int ceil = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                list1.add(nums[mid]);
            }

            if (nums[mid] >= target) {
                ceil = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if(list1.isEmpty()) return -1;

        return ceil;
    }
}