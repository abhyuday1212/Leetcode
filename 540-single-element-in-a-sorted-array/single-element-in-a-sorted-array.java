class Solution {
    // Brute: use two for loops T.c => O(n^2)
    // Better: use a HashMap T.c => O(n)
    // Optimal: Binary Search T.c => O(logn)

    public int singleNonDuplicate(int[] nums) {
        // Implementing HashMap
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int key: nums){
            mp.put(key,mp.getOrDefault(key,0) + 1);
        }

        //get the value where key value is 1

        for(int key: mp.keySet()){
            if(mp.get(key) == 1){
                return key;
            }
        }

        return 0;
    }
}