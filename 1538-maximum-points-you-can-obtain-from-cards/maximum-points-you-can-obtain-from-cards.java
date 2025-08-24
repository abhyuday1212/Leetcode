class Solution {
    public int maxScore(int[] cardPoints, int k) {
        long lSum = 0;
        long rSum = 0;
        int n = cardPoints.length;

        for(int i = 0; i < k && i < n; i++){
            lSum += cardPoints[i];
        }

        int maxSum = (int)lSum;

        int l = k - 1;
        int r = n - 1;

        while(l >= 0){
            rSum += cardPoints[r];
            r--;
            lSum -= cardPoints[l];
            l--;
            maxSum = Math.max(maxSum, (int)(rSum + lSum));
        }

        return maxSum;
    }
}