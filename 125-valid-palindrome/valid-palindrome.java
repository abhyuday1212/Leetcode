class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        // String modifiedStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int n = s.length();
        int l = 0, r = n - 1;
        char[] ch = s.toCharArray();

        while (l <= r) {
            if (ch[l] >= 'A' && ch[l] <= 'Z') {
                ch[l] += 32;
            }

            if (ch[r] >= 'A' && ch[r] <= 'Z') {
                ch[r] += 32;
            }

            if (!((ch[l] >= 'a' && ch[l] <= 'z') || (ch[l] >= '0' && ch[l] <= '9'))) {
                l++;
                continue;
            }
            if (!((ch[r] >= 'a' && ch[r] <= 'z') || (ch[r] >= '0' && ch[r] <= '9'))) {
                r--;
                continue;
            }

            if (ch[l] != ch[r]) {
                return false;
            }

            l++;
            r--;

        }

        return true;
    }
}