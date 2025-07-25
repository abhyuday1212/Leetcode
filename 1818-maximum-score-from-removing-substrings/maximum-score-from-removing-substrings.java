class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        boolean isXGreater = x > y;
        // x-> ab
        // y-> ba

        int gain = 0;

         if (isXGreater) {
            // First pass - remove "ab"
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == 'b') {
                    if (!st.isEmpty() && st.peek() == 'a') {
                        st.pop();
                        gain += x;
                    } else {
                       st.push(ch);    
                    }
                } else {
                    st.push(ch);
                }
            }

            // Remaining characters in stack need to be added to sb
            while (!st.isEmpty()) sb.append(st.pop());
            sb.reverse();

            st.clear();

            // Second pass - remove "ba"
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                if (ch == 'a') {
                    if (!st.isEmpty() && st.peek() == 'b') {
                        st.pop();
                        gain += y;
                    } else {
                        st.push(ch);
                    }
                } else {
                    st.push(ch);
                }
            }
        } else {
            // y > x, remove "ba" first
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == 'a') {
                    if (!st.isEmpty() && st.peek() == 'b') {
                        st.pop();
                        gain += y;
                    } else {
                       st.push(ch);    
                    }
                } else {
                    st.push(ch);    
                }
            }

            while (!st.isEmpty()) sb.append(st.pop());
            sb.reverse();

            st.clear();

            // Remove "ab"
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                if (ch == 'b') {
                    if (!st.isEmpty() && st.peek() == 'a') {
                        st.pop();
                        gain += x;
                    } else {
                        st.push(ch);
                    }
                } else {
                    st.push(ch);
                }
            }
        }

        return gain;
    }
}