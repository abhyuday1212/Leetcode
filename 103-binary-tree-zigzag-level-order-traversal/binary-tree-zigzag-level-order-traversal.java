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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null)
            return ans;

        q.add(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> sublevel = new ArrayList<>();

            // right to left
            for (int i = 0; i < n; i++) {
                TreeNode topElem = q.poll();
                sublevel.add(topElem.val);

                // find next elems
                if (topElem.left != null)
                    q.add(topElem.left);
                if (topElem.right != null)
                    q.add(topElem.right);
            }

            if (!leftToRight) {
                Collections.reverse(sublevel);
                ans.add(sublevel);
            } else {
                ans.add(sublevel);
            }
            
            leftToRight = !leftToRight;
        }

        return ans;
    }
}