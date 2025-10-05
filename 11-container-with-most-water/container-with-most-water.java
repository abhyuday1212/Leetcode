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
            int area = minHt * dif;

            maxArea = Math.max(maxArea, area);

            // if (height[l] <= height[r]) {
            //     l = l + 1;
            // } else {
            //     r = r - 1;
            // }

            // Optimization
            while (l < r && height[l] <= minHt)
                l++;
            while (l < r && height[r] <= minHt)
                r--;
        }

        return maxArea;
    }
}