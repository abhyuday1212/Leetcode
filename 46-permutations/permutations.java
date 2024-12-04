class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> myList = new ArrayList<>();

        List<List<Integer>> myAns = recursivePermute(myList, nums, 0);

        return myAns;

    }

    static List<List<Integer>> recursivePermute(List<Integer> newArr, int[] orgArr, int index) {
        // base case: If you reach the end, or the index == orgArr index then you should
        // terminate the function call
        if (orgArr.length == index) {
            List<List<Integer>> baseResult = new ArrayList<>();

            baseResult.add(new ArrayList<>(newArr)); // Add a copy of newArr to avoid reference issues

            return baseResult;
        }

        // Self work is that we have to calculate the current element and firstPlace and
        // seccondPlace by ourselves and ask recursion to do the remaing

        int currentElem = orgArr[index];

        List<List<Integer>> finalAns = new ArrayList<>();

        for (int i = 0; i <= newArr.size(); i++) {
            newArr.add(i, currentElem); // Insert at position `i`
            finalAns.addAll(recursivePermute(newArr, orgArr, index + 1));
            newArr.remove(i); // Backtrack: Remove the inserted element
        }
        return finalAns;

    }
}