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

            baseResult.add(newArr);

            return baseResult;
        }

        // Self work is that we have to calculate the current element and firstPlace and
        // seccondPlace by ourselves and ask recursion to do the remaing

        int currentElem = orgArr[index];

        List<List<Integer>> finalAns = new ArrayList<>();

        for (int i = 0; i <= newArr.size(); i++) {
            List<Integer> firstPlace = new ArrayList<>(newArr.subList(0, i)); // copy the elements from the newArr
            List<Integer> secondPlace = new ArrayList<>(newArr.subList(i, newArr.size())); // Copy from i to end

            firstPlace.add(currentElem);

            List<Integer> combined = new ArrayList<>(firstPlace); // This will just pass the copy, without modifying the
                                                                  // newArr
            combined.addAll(secondPlace);

            finalAns.addAll(recursivePermute(combined, orgArr, index + 1));

            // backtracking solution
            // newArr.remove(newArr.size() - 1); //-> This step will then not required as
            // newArr is not being modified

        }
        return finalAns;

    }
}