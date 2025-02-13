//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        // Your code here
        if(s.length() == 0) return s;
        
        String ans = "";
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            //here we need to handle four edge cases
            char ch = s.charAt(i);
            if ('A' <= ch && ch <= 'Z' || 'a' <= ch && ch <= 'z' || '0' <= ch && ch <= '9') {
                // in case of operands
                ans = ans + ch;
            } else if (ch == '(') {
                //opening bracket
                st.push(ch);
            } else if (ch == ')') {
                // closing bracket
                while (!st.isEmpty() && st.peek() != '(') {
                    ans = ans + st.peek();
                    st.pop();
                }
                st.pop();
            } else {
                // operator
                while (!st.isEmpty() && priority(ch) <= priority(st.peek())) {
                    ans = ans + st.peek();
                    st.pop();
                }
                st.push(ch);
            }
        }

        while(!st.empty()){
            ans += st.peek();
            st.pop();
        }
        
        return ans;
    }

    public static int priority(char ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        }
        return 0;
    }
        
    }