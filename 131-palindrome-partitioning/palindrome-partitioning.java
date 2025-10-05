class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();

        recursiveHelper(s, ds, ans);

        return ans;
    }

    public void recursiveHelper(String str, List<String> ds, List<List<String>> ans){
        int n = str.length();

        if(n == 0){
            // if(isPalindrome(str, 0, str.length() - 1)){
            //     ds.add(str);
            // }

            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 1; i <= n; i++){
            String newStr = str.substring(0, i);
            if(isPalindrome(newStr, 0, newStr.length() - 1)){
                ds.add(newStr);
                recursiveHelper(str.substring(i), ds, ans);
                ds.remove(ds.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}