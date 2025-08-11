class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Build Heap;
        for (int i = n - 1; i >= 0; i--) {
            maxHeap.add(stones[i]);
        }

        // extract first and second element from the maxHeap
        while (maxHeap.size() > 1) {
            int num1 = maxHeap.poll(); // top elem
            int num2 = maxHeap.poll(); // seccond top elem

            if (num1 != num2) {
                int diff = Math.abs(num1 - num2);
                maxHeap.add(diff);
            }

        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}