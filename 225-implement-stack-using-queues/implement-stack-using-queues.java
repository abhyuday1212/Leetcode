class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int front;

    public MyStack() {
        front = -1;
    }

    public void push(int x) {
        q2.add(x);

        front = x;

        // Transfer all the elements from q1 to q2, for reversing the queue
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swap q1 and q2.
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

    }

    public int pop() {
        int popped = q1.remove();

        if(!q1.isEmpty()){
            front = q1.peek();
        }
        else{
            front = -1;
        }

        return popped;
    }

    public int top() {
        return front;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */