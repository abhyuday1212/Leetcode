class Solution {
    public void rotate(int[] nums, int k) {
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;

        if(k > n) k = k % n;

        if(k == 0 || k == n) return;

        int target = n - k - 1;

        for(int i = target + 1; i < n; i++){
            temp.add(nums[i]);
        }

        for(int i = 0; i <= target; i++){
            temp.add(nums[i]);
        }

        System.out.println("List: " + temp);

        for(int i = 0; i < n; i++){
            nums[i] = temp.get(i);
        }
    }
}