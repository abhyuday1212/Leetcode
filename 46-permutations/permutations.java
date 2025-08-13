class Solution {
    // Method 1: visitedArr => has an extra space complexity
    // Method 2: Swap (Optimal)
    // => Keep Adding into the ds, and swapping the current index with the startIndex,
    // => startIndex will always update in the recursion call helping to know that you have to swap other elements from the index to nums.length - 1

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> myAns = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        findPermutaions(ds, nums, myAns, 0);

        return myAns;
    }

    public void findPermutaions(List<Integer> ds, int[] nums, List<List<Integer>> ans, int index){
        if(index == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        int startIndex = index;

        for(int i = index; i < nums.length ; i++){
            ds.add(nums[i]);
            swap(nums, startIndex, i);
            findPermutaions(ds, nums, ans, index + 1);
            swap(nums, startIndex, i);
            ds.remove(ds.size() - 1);
        }

    }

    public void swap(int[] nums, int i1, int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;

        return;
    }
}