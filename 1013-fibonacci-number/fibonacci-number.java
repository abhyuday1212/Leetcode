class Solution {
    public int fib(int n) {
        if(n<2){
            return n;
        }

        //Linear recursive Relation
        return fib(n-1)+ fib(n-2);
    }
}