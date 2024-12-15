class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ansList1 = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum1(new ArrayList<>(), candidates, target, 0, ansList1);

        return ansList1;
    }

        static void combinationSum1(List<Integer> ds, int[] orgArr, int target, int index, List<List<Integer>> ans) {
        // base condition
        if (index == orgArr.length) {

            if (target == 0) {
                ans.add(new ArrayList<>(ds));  //Add the copy of the newArray
            }
            return;
        }

        // If the current element is less than or equal to the target, consider taking it
        if (orgArr[index] <= target) {
            ds.add(orgArr[index]);
            combinationSum1(ds, orgArr, target - orgArr[index], index, ans);
            ds.remove(ds.size() - 1);
        }

        //not take
        combinationSum1(ds, orgArr, target, index + 1, ans);

    }
}