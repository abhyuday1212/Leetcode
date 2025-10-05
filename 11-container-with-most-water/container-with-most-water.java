class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int maxArea = 0;

        int leftMax = 0;
        int l = 0, r = n - 1;
        int rightMax = height[r];

        while (l < r) {
            int minHt = Math.min(height[l], height[r]);
            int dif = r - l;
            maxArea = Math.max(maxArea, minHt * dif);

            if (height[l] <= height[r]) {
                l = l + 1;
            } else {
                r = r - 1;
            }
        }

        return maxArea;
    }
}