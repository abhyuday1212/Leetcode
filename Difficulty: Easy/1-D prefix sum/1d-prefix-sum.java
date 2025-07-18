class Solution {
    public ArrayList<Integer> prefSum(int[] arr) {
       int sum = 0;
       ArrayList<Integer> ans = new ArrayList<>();
       
       for(int i = 0; i < arr.length; i++){
           sum += arr[i];
           ans.add(sum);
       }
       
       return ans;
    }
}