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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        // index

        dfsHelper(root, mp, ans, 0);

        return ans;
    }

    public void dfsHelper(TreeNode root, Map<Integer, Integer> mp, List<Integer> ans, int level) {
        if (root == null) {
            return;
        }

        if (!mp.containsKey(level)) {
            mp.put(level, root.val);
            ans.add(root.val);
        }

        dfsHelper(root.right, mp, ans, level + 1);
        dfsHelper(root.left, mp, ans, level + 1);
    }
}