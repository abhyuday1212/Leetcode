class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        Arrays.sort(piles);

        int start = 1;
        int end = piles[n - 1];

        int ans = 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int timeTaken = totalTimeWithKSpeed(piles, mid, h);

            // if (timeTaken == 0) return mid;

            if (timeTaken >= 0) { 
                //speed is greater so reduce the speed and check for the value lesser than this till mid is compensated
                ans = mid;  //possible Ans
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public int totalTimeWithKSpeed(int[] arr, int tempSpeed, int h) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= tempSpeed) {
                h = h - 1;
            } else { //current bananas is greater > than speed
                int timeRequired = arr[i] / tempSpeed;
                if (arr[i] % tempSpeed != 0) {
                    timeRequired += 1; //add extra time for the greater number of banas than tempSpeed
                }
                h = h - timeRequired;
            }
        }

        return h;
    }
}