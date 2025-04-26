class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Default MinHeap Priority Queue

        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }

        for(int i = k; i < n; i++){
            if(pq.peek() < nums[i]){
                // pop the top element and add the current element to it
                pq.poll();
                pq.add(nums[i]);
            }
        }


        // after this operation the peek element would be pointing towards the kth largest element
        return pq.peek();
    }
}