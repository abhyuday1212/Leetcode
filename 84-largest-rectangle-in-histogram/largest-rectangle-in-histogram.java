class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1)
            return heights[0];

        int[] prevSmall = findPrevSmall(heights);
        int[] nextSmall = findNextSmall(heights);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int currHt = heights[i];
            // width = next index - previous index - 1
            int w = nextSmall[i] - prevSmall[i] - 1;
            int area = w * currHt;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public int[] findPrevSmall(int[] arr) {
        int[] ans = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        int lastInd = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        } 

        return ans;
    }

    public int[] findNextSmall(int[] arr) {
        int[] ans = new int[arr.length];
        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }

    // -------------- My approach failed at 82 / 99.
    // public int largestRectangleArea(int[] heights) {
    // int n = heights.length;
    // if (n == 1) return heights[0];
    // if (n == 2 && heights[0] == 0 || heights[1] == 0) return Math.max(heights[0],
    // heights[1]);

    // int maxArea = 0;
    // Stack<Integer> stR = pushArr(heights);
    // Stack<Integer> stL = new Stack<>();
    // int width = 0;

    // for (int i = 1; i < n; i++) {
    // if (!stR.isEmpty()) {
    // stR.pop();
    // }

    // int ht = heights[i - 1]; // current ht

    // if (heights[i - 1] == heights[i]) {
    // width = width + 1;
    // int area = ht * (width + 1);
    // maxArea = Math.max(area, maxArea);
    // } else {
    // int rightWidth = findRightWidth(stR, heights, i - 1);
    // int leftWidth = findLeftWidth(stL, heights, i - 1);

    // int area = ht * (rightWidth + leftWidth + 1);
    // maxArea = Math.max(area, maxArea);
    // }

    // stL.push(heights[i - 1]);
    // }

    // return maxArea;
    // }

    // public int findRightWidth(Stack<Integer> stR, int[] arr, int index) {
    // Stack<Integer> st = new Stack<>();
    // st.addAll(stR);

    // int currentHt = arr[index];
    // int w = 0;

    // for (int i = index + 1; i < arr.length; i++) {

    // while (!st.isEmpty() && st.peek() >= currentHt) {
    // w += 1;
    // st.pop();
    // }

    // if (!st.isEmpty() && st.peek() < currentHt) {
    // return w;
    // }
    // }

    // return w;
    // }

    // public int findLeftWidth(Stack<Integer> stL, int[] arr, int index) {
    // Stack<Integer> st = new Stack<>();
    // st.addAll(stL);

    // int w = 0;
    // int currentHt = arr[index];

    // // if I am standing at 5 then LS => 2,1
    // while (!st.isEmpty() && st.peek() >= currentHt) {
    // w += 1;
    // st.pop();
    // }

    // if (!st.isEmpty() && st.peek() < currentHt) {
    // return w;
    // }

    // return w;
    // }

    // public static Stack<Integer> pushArr(int[] arr) {
    // Stack<Integer> st = new Stack<>();

    // for (int i = arr.length - 1; i >= 0; i--) {
    // st.push(arr[i]);
    // }

    // return st;
    // }
}