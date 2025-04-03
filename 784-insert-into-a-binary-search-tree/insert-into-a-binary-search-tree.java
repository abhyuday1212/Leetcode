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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
       
        TreeNode node = root;

        while(root != null){
           if(val < root.val && root.left == null){
                root.left = new TreeNode(val);
                break;
            }

            if( val > root.val && root.right == null){
                root.right = new TreeNode(val);
                break;
            }

            System.out.print(root.val);
            if(root.val < val){
                // move right
                root = root.right;
            }
            else{
                root = root.left;
            }
        }

        return node;
    }
}