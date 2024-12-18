class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> ans11 = new ArrayList<>();
         Arrays.sort(nums);
        nonDuplicateSubsets(new ArrayList<>(), nums, 0, ans11);
       return ans11;
    }

     static void nonDuplicateSubsets(List<Integer> ds, int[] orgArr, int index, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));

        for (int i = index; i < orgArr.length; i++) {
            if (i != index && orgArr[i] == orgArr[i - 1]) {
                continue;
            }

            ds.add(orgArr[i]);

//            System.out.println(orgArr[i]);

            // ! index i is already equal to index, so why here index + 1 didnt work?
            nonDuplicateSubsets(ds, orgArr, i + 1, ans);

            ds.remove(ds.size() - 1);
//            System.out.println(ds);

        }
    }
}