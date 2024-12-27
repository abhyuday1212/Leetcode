class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
         List<List<Integer>> finalAns = new ArrayList<>();
        int[] allowedElements = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        combinationSum3(new ArrayList<>(), allowedElements, 0, n, k, finalAns);
        System.out.println(finalAns);

        return finalAns;
    }

     public void combinationSum3(List<Integer> ds, int[] orgArr, int index, int target, int k, List<List<Integer>> ans) {
        //if target == 0, this means that particular combination of the data structure has valid combination
        if (target == 0 && ds.size() == k) {
            ans.add(new ArrayList<>(ds));  // Add the copy of the ds, as it is being modified below
            // System.out.println(ans);
            return;
        }

        //now running loop for various number of function calls at each level
        for (int i = index; i < 9; i++) {

            if (orgArr[i] > target || ds.size() >= k)
                break;

            if (i > index && orgArr[i] == orgArr[i - 1])
                continue;


            ds.add(orgArr[i]);

            combinationSum3(ds, orgArr, i + 1, target - orgArr[i], k, ans);

            ds.remove(ds.size() - 1);


        }

    }
}