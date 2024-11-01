class Solution {
    // base condition-> index >= s.length() || !Character.isDigit(s.charAt(index));
    // the main function will remove the leading white spaces and check for the sign
    // if s.isEmpty() not return 0, go for checking the sign

    // if Signedness,the string should be a number for this use if (s.charAt(index)
    // == '-') to find the sign of a number

    // Reading integers by skipping leading zero, this can be done via s.trim() to
    // remove the unwanted spaces (in beginning only)

    // Rounding part will see at last

    public int myAtoi(String s) {
        // Remove leading whitespaces
        s = s.trim();

        // If the string is empty or pointer has reached the last index then it will be
        // called, check for white spaces.
       if (s.isEmpty()) return 0;

        // Check for the sign
        int sign = 1;
        int index = 0;

        if (s.charAt(index) == '-'){
            sign = -1;
            index++;
        }  else if (s.charAt(index) == '+') {
            index++;
        }

        // Recursive helper function to process each digit
        return sign*helper(s, index, 0, sign);

    }

    static int helper(String s, int index, int result, int sign) {
        // Base case: stop if we've reached a non-digit character or the end of the  string or the operated chatacter is not a string
        if(s.length() <= index || !Character.isDigit(s.charAt(index))){
            return result;
        }

        // Get the digit at the current position,
        int digit = s.charAt(index) - '0';
         

        // Check for overflow
          if (result > (Integer.MAX_VALUE - digit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }


        // Recursive call to process the next character
        return helper(s, index + 1, digit + result * 10, sign);
    }

}