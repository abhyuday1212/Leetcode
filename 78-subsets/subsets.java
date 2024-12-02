class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = recursiveSubset(list, nums, 0);

        return ans;
    }

    public List<List<Integer>> recursiveSubset(List<Integer> newArr, int[] orgArr, int index) {
        if (index == orgArr.length) {
            List<List<Integer>> baseResult = new ArrayList<>();
            baseResult.add(new ArrayList<>(newArr)); // Add a copy of newArr
            return baseResult;
        }

        // ----implement take not take method, Recursion need to do two things, once it
        // need to calculate values when it has taken the characters
        // Now the question is what is the self work that we need to do
        // * The self work is to calculate at every index the element it is iterating
        // and then passing the current index as a parameter on the further recursion
        // calls.
        List<Integer> takenArr = new ArrayList<>(newArr);
        takenArr.add(orgArr[index]);
        List<List<Integer>> takenAns = recursiveSubset(takenArr, orgArr, index + 1);

        List<List<Integer>> notTakenAns = recursiveSubset(newArr, orgArr, index + 1);

        takenAns.addAll(notTakenAns);
        return takenAns;

    }

    // --------------------- Method 1
    // public List<List<Integer>> subsets(int[] nums) {
    // List<List<Integer>> outer = new ArrayList<>();
    // outer.add(new ArrayList<>());

    // for (int everyNum : nums) {
    // int n = outer.size();
    // for (int i = 0; i < n; i++) {
    // List<Integer> internal = new ArrayList<>(outer.get(i)); //! internal will be
    // the copy of outer.get(i)
    // internal.add(everyNum);

    // // This line will add both the lists (outer and internal or the remainig
    // one.)
    // outer.add(internal);
    // }
    // }

    // return outer;
    // }

}