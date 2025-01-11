class Solution {
    public int findKthPositive(int[] arr, int k) {

        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : arr) {
            mp.put(num, 1); // Mark these numbers as present
        }
  
        List<Integer> emptyList = new ArrayList<>();
  

        int current = 1;

        while (emptyList.size() < k) {
            if (!mp.containsKey(current)) {
                // If the current number is missing, add it to the list
                emptyList.add(current);
            }
            current++;
        }
 
        return emptyList.get(k-1);

    }
}