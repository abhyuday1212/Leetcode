class Solution {
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            // System.out.println("Ascii Val" + asciVal);
            
            if ('A' <= ch && ch <= 'Z' || 'a' <= ch && ch <= 'z' || '0' <= ch && ch <= '9'){
                // if the current character is operator
                ans += ch;
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                // closing bracket the 
                while(!st.isEmpty() && st.peek() != '('){
                    ans += st.pop();
                }
                st.pop(); // remove the opening bracket
            }
            else{
                //operator
                // find the priority
                int charPriority = findCharPriority(ch);
                // System.out.println("Char Priority: " + charPriority + "for char " + ch);
                
                while(!st.isEmpty() && charPriority <= findCharPriority(st.peek())){
                    //   System.out.println("Char Priority ==> " + findCharPriority(st.peek()) + "for char " + st.peek());
                    ans += st.pop();
                }
                st.push(ch);
            }
            
            // System.out.println("Loop: " + i + "=> "+ ans + " | ch => " + ch);
            
        }
        
        while(!st.isEmpty()){
            ans += st.pop();
        }
        
        return ans;
        
    }
    
    public static int findCharPriority(char ch){
        if(ch == '^') return 3;
        else if(ch == '*' || ch == '/') return 2;
        else if(ch == '+' || ch == '-') return 1;
        else return -1;
    }
    
}