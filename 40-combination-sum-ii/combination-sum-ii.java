class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ansList1 = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(new ArrayList<>(), candidates, target, 0, ansList1);

        return ansList1;
    }

    public void combinationSum2(List<Integer> ds, int[] orgArr, int target, int index, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));  // Add the copy of the ds, as it is being modified below
            // System.out.println(ans);
            return;
        }

        // *now run a for loop as variable number of recursion call is needed

        for (int i = index; i < orgArr.length; i++) {
            // ! check for duplicates
            if (i > index && orgArr[i] == orgArr[i - 1])
                continue;

            if (orgArr[i] > target)
                break;

            ds.add(orgArr[i]);

            // ! index i is already equal to index, so why here index + 1 didnt work?
            combinationSum2(ds, orgArr, target - orgArr[i], i + 1, ans);

            ds.remove(ds.size() - 1);
        }
    }
}