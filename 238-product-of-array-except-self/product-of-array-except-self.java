class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixMultiplyArr1 = new int[n];
        int[] prefixMultiplyArr2 = new int[n];

        int temp1 = 1;
        for(int i = 0; i < n; i++){
            temp1 *= nums[i];
            prefixMultiplyArr1[i] = temp1;
        }
        
        int temp2 = 1;
        for(int i = n - 1; i >= 0; i--){
            temp2 *= nums[i];
            prefixMultiplyArr2[i] = temp2;
        }

        // System.out.println("prefixMultiplyArr1: " + Arrays.toString(prefixMultiplyArr1));
        // System.out.println("prefixMultiplyArr2: " + Arrays.toString(prefixMultiplyArr2));

        int[] ans = new int[n];
        ans[0] = prefixMultiplyArr2[1];
        ans[n - 1] = prefixMultiplyArr1[n - 2];

        for(int i = 1; i < n - 1; i++){
            int prod = prefixMultiplyArr1[i - 1] * prefixMultiplyArr2[i + 1];
            ans[i] = prod;
        }

        return ans;
    }
}