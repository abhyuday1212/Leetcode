class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        char maxChar = '\0'; // null character

        for (int i = 2; i < n; i++) {
            char curChar = num.charAt(i);
            char prevChar = num.charAt(i - 1);
            char prevPrevChar = num.charAt(i - 2);

            if (curChar == prevChar && prevChar == prevPrevChar) {
                if (curChar > maxChar) {
                    maxChar = curChar;
                }
            }
        }

        if (maxChar == '\0') {
            return "";
        }

        return "" + maxChar + maxChar + maxChar;
    }
}