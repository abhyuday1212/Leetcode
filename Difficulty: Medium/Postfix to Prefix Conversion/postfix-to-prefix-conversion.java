//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        String exp = post_exp.trim();
        Stack<String> st = new Stack<>();
        int n = exp.length();

        for (int i = 0; i < exp.length() ; i++) {
            char ch = exp.charAt(i);

            // This can be also used to check for the letter
            // if (Character.isLetterOrDigit(ch))
            if ('A' <= ch && ch <= 'Z' || 'a' <= ch && ch <= 'z' || '0' <= ch && ch <= '9') {
                // if the character is a operand
//                st.push(ch + "");
                st.push(Character.toString(ch));
            } else {
                // it is operator
                String secondElem = st.peek(); // Pop second operand first
                st.pop();

                String firstElem = st.peek(); // Pop first operand second
                st.pop();

                String result = ch + firstElem + secondElem; // Correct order
                st.push(result);

            }
        }

        return st.peek();
    }
}
