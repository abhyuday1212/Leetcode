class Solution {
    // Brut: Striver
    public long subArrayRanges(int[] nums) {
        long sum = 0;

        // find the shape

        for(int i = 0; i < nums.length; i++){
            long largest = nums[i];
            long smallest = nums[i];
            for(int j = i; j < nums.length; j++){
                largest = Math.max(nums[j],largest);
                smallest = Math.min(nums[j], smallest);

                sum = sum + (largest - smallest);
            }
        }

        return sum;
    }

    // My Method
    // Brut: Generate all the sub arrays and then find the range from the max and
    // This gave TLE
    // public long subArrayRanges(int[] nums) {
    // List<List<Integer>> subArrays = findSubset(new ArrayList<>(), nums, 0, -1);
    // long sum = 0;

    // for (int i = 0; i < subArrays.size(); i++) {
    // // [1,3 ,2]
    // long min = findMin(subArrays.get(i));
    // long max = findMax(subArrays.get(i));

    // long range = max - min;
    // sum += range;
    // }

    // return sum;

    // }

    // public List<List<Integer>> findSubset(List<Integer> ds, int[] orgArr, int
    // index, int lastIndex) {
    // List<List<Integer>> ans = new ArrayList<>();
    // if (!ds.isEmpty()) {
    // System.out.println(ds);
    // ans.add(new ArrayList<>(ds));
    // }

    // if (index == orgArr.length) {
    // return ans;
    // }

    // for (int i = index; i < orgArr.length; i++) {
    // if (!ds.isEmpty() && lastIndex != i - 1) {
    // continue;
    // }

    // ds.add(orgArr[i]);

    // // ! index i is already equal to index, so why here index + 1 didnt work?
    // List<List<Integer>> halfAns = findSubset(ds, orgArr, i + 1, i);
    // ds.remove(ds.size() - 1);

    // ans.addAll(halfAns);
    // }

    // return ans;
    // }

    // public long findMin(List<Integer> arr) {
    // if(arr.size() == 0) return 0;

    // long min = Long.MAX_VALUE;

    // for (int i = 0; i < arr.size(); i++) {
    // min = Math.min(arr.get(i), min);
    // }

    // return min;
    // }

    // public long findMax(List<Integer> arr) {
    // if(arr.size() == 0) return 0;

    // long max = Long.MIN_VALUE;
    // for (int i = 0; i < arr.size(); i++) {
    // max = Math.max(arr.get(i), max);
    // }

    // return max;
    // }
}