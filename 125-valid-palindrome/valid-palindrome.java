class Solution { 

    public boolean isPalindrome(String s) { 
        if (s == null || s.length() == 0) {
            return true;
        }
 
        // Remove all non-alphanumeric characters and convert to lowercase
        String result = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Use a recursive method to check if the string is a palindrome
        return isPalindromeRecursively(result, 0, result.length() - 1);
    }

    private boolean isPalindromeRecursively(String str, int left, int right) {
        // Base case: If the pointers have crossed, it's a palindrome
        if (left >= right) {
            return true;
        }

        // Check if characters at the current pointers are equal
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        // Move the pointers inward and check recursively
        return isPalindromeRecursively(str, left + 1, right - 1);
    }
}
