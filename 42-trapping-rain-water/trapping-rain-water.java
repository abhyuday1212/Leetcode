class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] leftMax = prefixMax(height);
        int[] rightMax = suffixMax(height);

        for (int i = 0; i < n; i++) {
            if (height[i] < leftMax[i] && height[i] < rightMax[i]) {
                sum = sum + (Math.min(leftMax[i], rightMax[i])) - height[i];
            }
        }

        return sum;
    }

    public int[] prefixMax(int[] height) {
        // it has similar concept of prefixMax
        int n = height.length;
        int[] prefix = new int[n];

        prefix[0] = height[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(height[i], prefix[i - 1]);
        }

        return prefix;
    }

    public int[] suffixMax(int[] height) {
        // it has similar concept of suffixMax
        int n = height.length;
        int[] suffix = new int[n];

        suffix[n - 1] = height[n - 1];

        for (int i = n - 2; 0 <= i; i--) {
            suffix[i] = Math.max(height[i], suffix[i + 1]);
        }

        return suffix;
    }
}