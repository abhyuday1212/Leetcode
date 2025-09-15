class Solution {
    public String largestSwap(String s) {
        int n = s.length();
        if (n < 2) return s;

        char[] a = s.toCharArray();

        // track best suffix maximum seen so far (from right)
        char maxChar = a[n - 1];
        int maxPos = n - 1;

        // candidate swap positions
        int left = -1, right = -1;

        // scan from right to left
        for (int i = n - 2; i >= 0; --i) {
            if (a[i] > maxChar) {
                // new maximum in suffix
                maxChar = a[i];
                maxPos = i;
            } else if (a[i] < maxChar) {
                // a swap with maxPos would improve; record it
                left = i;
                right = maxPos;
                // keep scanning — because we go leftwards, any future assignment
                // will be to a smaller index i (which is desirable)
            }
        }

        if (left == -1) return s; // already maximal

        // perform the swap
        char tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;

        return new String(a);
    }
}
