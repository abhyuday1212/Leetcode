class Solution {
    //Tc: O(2n)
    // Sc: O(1)
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0, rSum = 0, maxSum = 0;
        int n = cardPoints.length;

        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }

        maxSum = lSum;

        int rightIndex = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            lSum = lSum - cardPoints[i];
            rSum = rSum + cardPoints[rightIndex];

            rightIndex -= 1;
            maxSum = Math.max(maxSum, lSum + rSum);
        }

        return maxSum;
    }
}