class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long result = 0;

        for(int num: nums){
            if(num == 0){
                count++;
                result += count;
            }
            else{
                count = 0;
                // there must be a break in subarr as non 0 number encountered
            }
        }

        return result;
    }
}