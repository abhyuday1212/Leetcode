class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        String modifiedStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int n = modifiedStr.length();
        int l = 0, r = n - 1;

        while(l <= r){
            if(modifiedStr.charAt(l) != modifiedStr.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}