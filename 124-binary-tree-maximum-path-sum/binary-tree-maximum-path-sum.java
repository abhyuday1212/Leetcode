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
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;

        findPathSum(root);

        return maxPathSum;
    }

    int findPathSum(TreeNode root){
        if(root == null){
            return 0;
        }

        maxPathSum = Math.max(maxPathSum, root.val);

        // int left = findPathSum(root.left);
        // int right = findPathSum(root.right);
        int left = Math.max(0, findPathSum(root.left));
        int right = Math.max(0, findPathSum(root.right));

        int curPathSum = root.val + left + right;
        maxPathSum = Math.max(maxPathSum, curPathSum);

        return root.val + Math.max(left, right);
    }

}