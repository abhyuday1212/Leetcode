class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = n - 1; i>= 2; i--){
            if(nums[i - 1] + nums[i - 2] > nums[i]){
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }

        return 0;
    }

    // BRUT
    // public int largestPerimeter(int[] nums) {
    //     int n = nums.length;
    //     int maxP = 0;

    //     for(int i = 0; i < n; i++){
    //         for(int j = i + 1; j < n; j++){
    //             for(int k = j + 1; k < n; k++){
    //                 int curP = nums[i] + nums[j] + nums[k];
    //                 if(isTrianglePossible(nums[i], nums[j], nums[k]) && curP >= maxP){
    //                     maxP = curP;
    //                 }
    //             }
    //         }
    //     }

    //     return maxP;
    // }

    public boolean isTrianglePossible(int a, int b, int c){
        if(a + b > c && a + c > b && b + c > a){
            return true;
        }

        return false;
    }
}