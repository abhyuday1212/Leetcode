class Solution {
    // S-0:
    private Map<Integer, Integer> dp = new HashMap<>(); // you can also create a helper function and pass this into that

    public int fib(int n) {
        // step 3
        if(n<2){
            return n;
        }

        //S-2:
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        //Linear recursive Relation
        // S-1:
        int result = fib(n - 1) + fib(n - 2);
        dp.put(n, result);
        return result;
    }
}