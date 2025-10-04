class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int total =0;
        int leftMax = 0;

        int rightMax = 0;
        int l = 0, r = n - 1;

        while(l < r){
            if(height[l] <= height[r]){
                // traverse from left word
                if(leftMax > height[l]){
                    total += leftMax - height[l];
                }
                else{
                    // the height at which you are at is leftmax itselt
                    leftMax = height[l];
                }
                l = l + 1;
            }
            else{
                // traverse from right word
                if(height[r] < rightMax){
                    total += rightMax - height[r];
                }
                else{
                    rightMax = height[r];
                }
                r = r - 1;
            }
        }

        return total;
    }
}