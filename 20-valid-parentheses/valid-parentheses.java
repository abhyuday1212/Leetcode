class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        boolean ans = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                // current wla closing character h
                if (stack.isEmpty())
                    return false;

                char poppedBracket = stack.peek();
                stack.pop(); // also pop the bracket from the stack

                if (poppedBracket == '(' && s.charAt(i) == ')' || poppedBracket == '[' && s.charAt(i) == ']'
                        || poppedBracket == '{' && s.charAt(i) == '}') {
                    ans = true;
                } else {
                    return false;
                }

            }
        }

        if(!stack.isEmpty()) return false;

        return ans;
    }
}