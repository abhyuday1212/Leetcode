/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helperFn(root, 0, list);
        return list;
    }

    public void helperFn(TreeNode root, int level, List<Integer> ds) {
        if (root == null) {
            return;
        }

        // check for elements to add in ds if and only if it is obtained for the first
        // time in that level
        if (level == ds.size()) {
            ds.add(root.val);
        }

        // reversed preorder
        helperFn(root.right, level + 1, ds);
        helperFn(root.left, level + 1, ds);
    }
}