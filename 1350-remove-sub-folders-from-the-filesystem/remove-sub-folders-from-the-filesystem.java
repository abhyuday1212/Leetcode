class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();
        Arrays.sort(folder);

        int n = folder.length;
     

        for (int i = 0; i < n; i++) {
            String curStr = folder[i];
            // System.out.println(curStr);

            if (curStr != null && curStr.length() >= 2) {
                String subStr = removeLast(curStr);
                // System.out.println("subStr: " + subStr);

                if (!isParentFolderExists(subStr, mp)) {
                    ans.add(folder[i]);
                }
            }
            else if(curStr != null){
                ans.add(folder[i]);
            }

            mp.put(folder[i], 1);
        }

        return ans;
    }

    boolean isParentFolderExists(String str, HashMap<String, Integer> mp){
        if(str.length() < 2){
            return false;
        }

        if(mp.containsKey(str)){
            return true;
        }

        return isParentFolderExists(removeLast(str), mp);
    }

    public static String removeLast(String s) {
        int lastSlashIndex = s.lastIndexOf('/');

        if (lastSlashIndex <= 0) {
            return ""; 
        }

        return s.substring(0, lastSlashIndex);
    }
}