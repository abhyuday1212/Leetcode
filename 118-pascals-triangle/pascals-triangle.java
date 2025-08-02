class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        // List<Integer> add1 = new ArrayList<>();
        
        // add1.add(1);
        // ans.add(add1);
        ans.add(Arrays.asList(1));

        // System.out.println("Ans: " + ans);

        for (int i = 1; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            level.add(1);

            // calculate sum and put into level
            for (int j = 1; j < ans.get(i - 1).size(); j++) {
                int sum = ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1);
                level.add(sum);
            }

            level.add(1);
            // System.out.println("Ans After this level: " + ans);
            ans.add(level);
        }

        return ans;
    }
}