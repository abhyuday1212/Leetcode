class Pair {
    int val, minVal;

    Pair(int val, int minVal) {
        this.val = val;
        this.minVal = minVal;
    }

}

class MinStack {
    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        int min;

        if (st.isEmpty()) {
            min = val;
        } else {
            min = Math.min(st.peek().minVal, val);
        }

        st.push(new Pair(val, min));
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().val;
    }

    public int getMin() {
        return st.peek().minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */