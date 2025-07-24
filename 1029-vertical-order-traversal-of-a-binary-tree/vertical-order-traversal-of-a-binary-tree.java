/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair {
    int col;
    TreeNode node;

    public Pair(int col, TreeNode node) {
        this.col = col;
        this.node = node;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, List<Integer>> colMap = new TreeMap<>();
        // index of column, List of numbers present at this coulumn
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        q.add(new Pair(0, root));

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();

            // for this level only: col -> list of node values
            Map<Integer, List<Integer>> levelMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                Pair curPair = q.poll();
                int curCol = curPair.col;
                TreeNode curNode = curPair.node;

                levelMap.computeIfAbsent(curCol, k -> new ArrayList<>()).add(curNode.val);

                if (curNode.left != null)
                    q.offer(new Pair(curCol - 1, curNode.left));
                if (curNode.right != null)
                    q.offer(new Pair(curCol + 1, curNode.right));
            }

            // now sublevel will have some values
            // sort values in each column for this level, then merge

            for(Integer column: levelMap.keySet()){
                List<Integer> vals = levelMap.get(column);

                Collections.sort(vals);

                if(!colMap.containsKey(column)){
                    colMap.put(column, new ArrayList<>());
                }

                colMap.get(column).addAll(vals);
            }
            
        }

        ans = new ArrayList<>(colMap.values());
        return ans;
    }
}