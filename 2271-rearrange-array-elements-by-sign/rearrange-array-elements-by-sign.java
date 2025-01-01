class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        List<Integer> positiveList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();

        // separate possitive and the negatives
        for(int i = 0; i < n ; i++){
            //what to do of 0?
            if(nums[i]> 0){
                positiveList.add(nums[i]);
            }
            else{
                negativeList.add(nums[i]);
            }
        }

        //now you have the possitive and the negative elements, now transform the given array
        for(int i = n-1; i >= 0 ; i--){
            if(i%2 == 0){
                nums[i] = positiveList.get(positiveList.size() - 1);
                positiveList.remove(positiveList.size() - 1);
            }
            else if(i%2 != 0){
                nums[i] = negativeList.get(negativeList.size() - 1);
                negativeList.remove(negativeList.size() - 1);
            }
        } 


        return nums;
    }
}