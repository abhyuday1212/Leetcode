class Solution {
    // Tc: O(5n) ,  SC: O(5n)
    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        long totalSum = 0;
        long mod = (long) (1e9 + 7);

        for (int i = 0; i < arr.length; i++) {
            // total number of contributions of each elements
            long right = nse[i] - i;
            long left = i - psee[i];

            long totalContribution = (left * right * arr[i]) % mod;

            totalSum = (totalSum + totalContribution) % mod;
        }

        return (int) totalSum;
    }

    public int[] findNSE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];

        for (int i = n - 1; -1 < i; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    public int[] findPSEE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pse;
    }

    // ----------------------------

    // This gave TLE 79/88, but the solution is correct
    // public int sumSubarrayMins(int[] arr) {
    // // brut T.C : O(n^2)

    // int sum = 0;
    // int mod = (int) (1e9 + 7);

    // for(int i =0; i< arr.length; i++){
    // int min = arr[i];

    // for(int j = i; j < arr.length; j++){
    // min = Math.min(min, arr[j]);
    // sum = (sum + min)%mod;
    // }
    // }

    // return sum;

    // }
}