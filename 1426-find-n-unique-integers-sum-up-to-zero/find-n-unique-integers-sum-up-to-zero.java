class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];

        if (n % 2 == 0) {
            // even
            int l = 1;
            int r = -1;

            int arrIndex = 0;

            while(arrIndex < n){
                ans[arrIndex++] = l++;
                ans[arrIndex++] = r--;
            }
        } else {
            // odd
            int l = 1;
            int r = -1;

            int arrIndex = 1;

            ans[0] = 0;
            
            while(arrIndex < n){
                ans[arrIndex++] = l++;
                ans[arrIndex++] = r--;
            }
        }

        return ans;
    }
}