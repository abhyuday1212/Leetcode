class Solution {
    public int countHillValley(int[] nums) {
        // int n = nums.length;
        // int count = 0;

        // for (int i = 1; i < n - 1; i++) {
        //     if (nums[i] == nums[i - 1])
        //         continue;

        //     int cur = nums[i];
        //     int left = i - 1;
        //     int right = i + 1;

        //     while (left >= 0 && nums[left] == cur) {
        //         left--;
        //     }

        //     while (right < n - 1 && nums[right] == cur) {
        //         right++;
        //     }

        //     if (left >= 0 && right < n) {
        //         if (nums[left] < cur && nums[right] < cur) {
        //             count++;
        //         }

        //         if (cur < nums[left] && cur < nums[right]) {
        //             count++;
        //         }
        //     }

        // }

        // return count;

        int prev = nums[0];
        int n = nums.length;
        int count = 0;

        for(int i=1; i<n-1; i++){
            if(nums[i] > prev && nums[i] > nums[i+1] || nums[i] < prev && nums[i] < nums[i+1]){
                count++;
                prev = nums[i];
            }
        }
        return count;
    }
}

// BRUT: Find the left and right Non equal Elems and store them
/* 
class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;

        int[] leftElems = new int[n];
        int[] rightElems = new int[n];

        for (int i = 1; i < n - 1; i++) {
            leftElems[i] = findLeftNonEqualElem(i, nums);
            rightElems[i] = findRightNonEqualElem(i, nums);
        }

        // System.out.println("Left Elems: " + Arrays.toString(leftElems) );
        // System.out.println("rightElems: " + Arrays.toString(rightElems));

        int hill = 0;
        int valley = 0;

        int leftLast = -1;
        int rightLast = -1;

        for (int i = 1; i < n - 1; i++) {
            if (leftLast == leftElems[i] && rightLast == rightElems[i]){
                // System.out.println("1. Reverted back for i: " + i);
                continue;
            }

            if(leftElems[i] == 0 || rightElems[i] == 0){
                // System.out.println("2. Reverted back for i: " + i);
                continue;
            }

            // System.out.println("Nums: " + nums[i]);

            if (leftElems[i] < nums[i] && rightElems[i] < nums[i] ) {
                // System.out.println("Counted hill for index: " + i + " & " + nums[i]);
                hill++;
            } else if (nums[i] < leftElems[i] && nums[i] < rightElems[i]) {
                // System.out.println("Counted valley for index: " + i + " & " + nums[i]);
                valley++;
            }
            leftLast = leftElems[i];
            rightLast = rightElems[i];
        }

        return hill + valley;
    }

    public int findRightNonEqualElem(int curIndex, int[] arr) {
        for (int i = curIndex + 1; i < arr.length; i++) {
            if (arr[curIndex] != arr[i]) {
                return arr[i];
            }
        }

        return 0;
    }

    public int findLeftNonEqualElem(int curIndex, int[] arr) {
        for (int i = curIndex - 1; i >= 0; i--) {
            if (arr[curIndex] != arr[i]) {
                return arr[i];
            }
        }

        return 0;
    }
}
*/