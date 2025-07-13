class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];

        if(k > n) k = k % n;

        if(k == 0 || k == n) return;

        int target = n - k;

        for(int i = target; i < n; i++){
            temp[i- target] = nums[i];
        }

        for(int i = 0; i < target; i++){
           temp[k + i] = nums[i];
        }

        for(int i = 0; i < n; i++){
            nums[i] = temp[i];
        }
    }
}