class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int everyNum : nums) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));     //! internal will be the copy of outer.get(i)
                internal.add(everyNum);

                // This line will add both the lists (outer and internal or the remainig one.)
                outer.add(internal);
            }
        }

        return outer;
    }

}