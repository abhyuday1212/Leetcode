class Solution {
    // Using the Max Heap Approach
    /*
    Time Complexity: O(n + k log n) 
    Stack Overflow
    Stack Overflow
    
    Space Complexity: O(n)
     */
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    //     // Build heap in O(n)
    //     maxHeap.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    //     // Extract max k-1 times
    //     for (int i = 1; i < k; i++) {
    //         maxHeap.poll();
    //     }
    //     return maxHeap.peek();
    // }

    // TC: O(Nlog(k))
    // Using Min-Heap approach
    // Faster
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