class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> mp = new HashMap<>();

        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] nge = new int[n2];
        int[] ans = new int[n1];

        //S-1 find the NGE of all the elements
        for (int i = n2 - 1; i >= 0; i--) {
            int curElem = nums2[i];

            mp.put(curElem, i);

            while (!st.isEmpty() && st.peek() < nums2[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                // top element in the stack is now greater
                nge[i] = st.peek();
            }

            mp.put(curElem, nge[i]);
            st.push(curElem);
        }

        //S-2 put the elems in the ans arr
        for(int i = 0; i < n1; i++){
            ans[i] = mp.get(nums1[i]);
        }

        return ans;
    }
}