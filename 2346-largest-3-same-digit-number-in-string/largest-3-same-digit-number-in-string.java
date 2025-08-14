class Solution {
    // 0ms
    public String largestGoodInteger(String num) {
        String[] numbers = { "999", "888", "777", "666", "555", "444", "333", "222", "111", "000" };
        for (String i : numbers) {
            if (num.contains(i)) {
                return i;
            }
        }
        return "";
    }

    // 7ms
    // public String largestGoodInteger(String num) {
    //     int n = num.length();
    //     char maxChar = '\0'; // null character

    //     for (int i = 2; i < n; i++) {
    //         char curChar = num.charAt(i);
    //         char prevChar = num.charAt(i - 1);
    //         char prevPrevChar = num.charAt(i - 2);

    //         if (curChar == prevChar && prevChar == prevPrevChar) {
    //             if (curChar > maxChar) {
    //                 maxChar = curChar;
    //             }
    //         }
    //     }

    //     if (maxChar == '\0') {
    //         return "";
    //     }

    //     return "" + maxChar + maxChar + maxChar;
    // }
}