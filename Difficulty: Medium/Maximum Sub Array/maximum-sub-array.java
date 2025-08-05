// User function Template for Java

class Solution {
    public ArrayList<Integer> findSubarray(int arr[]) {
        int n = arr.length;
        
        int maxSum = Integer.MIN_VALUE;

        int sum = 0;
        
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(arr[i] >= 0){
                sum += arr[i];
                ds.add(arr[i]);
                if(sum >= maxSum){
                    ans.clear();
                    ans.addAll(ds);
                    maxSum = sum;
                }
            }
            else {
                sum = 0;
                // ans.remove(ans.size() - 1);
                ds.clear();
                continue;
            }
        }
        
        if (ans.isEmpty()) {
            ArrayList<Integer> emptyResult = new ArrayList<>();
            emptyResult.add(-1);
            return emptyResult;
        }

        return ans;
    }
}