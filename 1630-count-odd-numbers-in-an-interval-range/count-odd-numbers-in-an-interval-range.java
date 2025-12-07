class Solution {
    public int countOdds(int low, int high) {
        int ans = 0;
        if (low % 2 != 0) {
            ans = 1 + (high - low) / 2;
        } else {
            if (high % 2 == 0) {
                ans = (high - low) / 2;
            } else {
                ans = 1 + (high - low) / 2;
            }
        }

        return ans;
    }
}