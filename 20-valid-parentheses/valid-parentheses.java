class Solution {
    public boolean isValid(String s) {
        Stack<Character> st1 = new Stack<>();

        boolean ans = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                st1.push(ch);
                ans = false;
            }
            else {
                //agr closing aaye to while loop lga k s2 me daal do
                if (st1.isEmpty()) {
                    return false;
                }

                char poppedChar = st1.pop();

                if (poppedChar == '(' && ch == ')' || poppedChar == '{' && ch == '}' || poppedChar == '['
                        && ch == ']') {
                    ans = true;
                } else {
                    return false;
                }

            }

        }

        if(!st1.isEmpty()) return false;


        return ans;
    }
}