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
    public boolean isBalanced(TreeNode root) {
        return findHeight(root) == -1 ? false : true;
    }

    // Tc: O(N)
    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = findHeight(root.left);
        if (left == -1)
            return -1;

        int right = findHeight(root.right);
        if (right == -1)
            return -1;

        // check for isBalanced
        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }
}