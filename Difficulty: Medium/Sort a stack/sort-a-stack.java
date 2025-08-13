/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> ans = new Stack<>();
        return recursiveHelper(ans, s);
    }
    
    public Stack<Integer> recursiveHelper(Stack<Integer> ans, Stack<Integer> orgSt){
        if(orgSt.isEmpty()){
            return ans;
        }
        
        int cur = orgSt.pop();
        
        Stack<Integer> temp = new Stack<>();
        
        while(!ans.isEmpty() && cur < ans.peek()){
            temp.add(ans.pop());
        }
        
        // add the top element from the orgSt
        ans.add(cur);
        
        while (!temp.isEmpty()) {
            ans.push(temp.pop());
        }
                
        
        return recursiveHelper(ans, orgSt);
    }
}