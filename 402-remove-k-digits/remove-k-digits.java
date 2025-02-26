class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();

        if (k == n)
            return "0";

        // put the number in the stack one by one
        Stack<Character> st = new Stack<>();
        char[] ch = num.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            while (!st.isEmpty() && st.peek() > ch[i] && k > 0) {
                st.pop();
                k--;
            }
            st.push(ch[i]);
        }

        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        ans.reverse();

        while (ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        return ans.length() == 0 ? "0" : ans.toString();

    }

    // My Approach: Gave error so didnt solved it further
    // public String removeKdigits(String num, int k) {
    // if (k == num.length())
    // return "0";

    // // move the sliding window and keep the track of the minimum
    // // int smallestInteger = Integer.MAX_VAL;
    // char[] ch = num.toCharArray();
    // String ans = "0";
    // int lastElem = Integer.MIN_VALUE;

    // for (int i = 0; i < ch.length; i++) {
    // if (lastElem < ch[i] - '0' && i != 0) {
    // ans = newAns(ch, i, k);

    // if (ans.isEmpty()) {
    // return "0";
    // }

    // return ans;
    // }

    // lastElem = ch[i] - '0';
    // }

    // return ans;
    // }

    // public String newAns(char[] ch, int index, int k) {
    // String ans = "";
    // for (int i = 0; i < index; i++) {
    // if (ch[i] == '0' && ans.isEmpty())
    // continue;

    // ans += ch[i];
    // System.out.println("loop 1..." + ans);
    // }

    // for (int j = index + k; j < ch.length; j++) {
    // // before adding this line runtime was 4ms and after adding it became 6ms
    // if (ch[j] == '0' && ans.length() == 0)
    // continue;

    // ans += ch[j];
    // System.out.println("loop 2..." + ans);
    // }

    // return ans;
    // }

    // public String removeLeadingZeros(String str) {

    // if (str.length() == 0) {
    // return str;
    // }
    // if (str.charAt(0) == '0') {
    // str = removeLeadingZeros(str.substring(1));
    // return str;
    // }

    // return str;
    // }
}