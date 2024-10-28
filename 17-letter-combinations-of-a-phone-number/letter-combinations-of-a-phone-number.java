class Solution {
       public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> finalAns = letterCombinationRetArrayList("", digits);
        return finalAns;
    }


        static List<String> letterCombinationRetArrayList(String newStr, String originalStr) {
        if (originalStr.isEmpty()) {
            List<String> ans =new ArrayList<>();
            ans.add(newStr);
            return ans;
        }

        //convert character into unicode/ asccci values
         char firstDigit = originalStr.charAt(0);
        String letters = getLettersForDigit(firstDigit); 

        List<String> ans = new ArrayList<>();

       for (char ch : letters.toCharArray()) {
            ans.addAll(letterCombinationRetArrayList(newStr + ch, originalStr.substring(1)));
        }

        return ans;
    }

       static String getLettersForDigit(char digit) {
        switch (digit) {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default: return "";
        }
    }
}