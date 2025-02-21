class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = nums[i % n];

            while (!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }

            // Only update the answer when i is in the first pass (i < n)
            if (i < n) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(curr);
        }

        return ans;
    }
}