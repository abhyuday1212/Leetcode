import java.math.BigInteger;

class Solution {
    // recursive Approach

    // -----------------------------
    // Long data type is failing for very large integers
    public String largestOddNumber(String num) {
        String maxOdd = recursiveFun(num, "1");

        if (maxOdd.isEmpty()) {
            return "";
        }

        return maxOdd;
    }

    public static String recursiveFun(String num, String maxOdd) {
        if (num.isEmpty()) {
            return "";
        }

        char lastChar = num.charAt(num.length() - 1);
        int lastDigit = lastChar - '0';

        if (lastDigit % 2 != 0) {
            maxOdd = num;
            return num;
        }  

        return recursiveFun(num.substring(0, num.length() - 1), maxOdd);
    }

    // public String largestOddNumber(String num) {
    // String maxOdd = recursiveFun(num, "1");

    // if (maxOdd.isEmpty()) {
    // return "";
    // }

    // return maxOdd;
    // }

    // public static String recursiveFun(String num, String maxOdd) {
    // if (num.isEmpty()) {
    // return "";
    // }

    // long intVal = Long.parseLong(num);

    // if (intVal % 2 != 0) {
    // // Update maxOdd if the current value is larger
    // return maxOdd = Long.toString(Math.max(Long.parseLong(maxOdd), intVal));
    // }

    // return recursiveFun(num.substring(0, num.length() - 1), maxOdd);
    // }

    // --------------------------------------------
    // Runtime: 0ms, 103/196 passed
    // public String largestOddNumber(String num) {
    // String[] singularNums = num.split("");

    // int n = singularNums.length;

    // String maxOdd = "1";

    // if (individualVal % 2 != 0) {
    // maxOdd = Long.toString(individualVal);
    // flag = true;
    // }

    // for (int i = 0; i < n; i++) {
    // long intVal = Long.parseLong(singularNums[i]);

    // if (intVal % 2 != 0) {
    // // Update maxOdd if the current value is larger
    // flag = true;
    // maxOdd = Long.toString(Math.max(Long.parseLong(maxOdd), intVal));
    // }
    // }

    // // String ans = Integer.toString(maxOdd || null);

    // if (!flag) {
    // return "";
    // } else {
    // return maxOdd;
    // }
    // }
}