class Solution {
    // BRUT: O(N⋅KlogK).
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        int n = strs.length;
        List<String> sortedStrs = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String cur = strs[i]; // list
            char[] chArr = cur.toCharArray();
            Arrays.sort(chArr);
            
            String sortedStr = new String(chArr);

            if (!mp.containsKey(sortedStr)) {
                mp.put(sortedStr, ans.size());
                ans.add(new ArrayList<>());
            }

            int index = mp.get(sortedStr);

            // get the inner list from the ans
            ans.get(index).add(strs[i]);

        }

        return ans;
    }
}