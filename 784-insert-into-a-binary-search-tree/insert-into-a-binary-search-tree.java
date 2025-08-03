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
        TreeNode head = root;

        if(root == null){
            return new TreeNode(val);
        }
        
        TreeNode prev = null;

        while(head != null || head != null){
            if(head.val > val){
                prev = head;
                head = head.left;
            }
            else{
                prev = head;
                head = head.right;
            }
        }

        if(val < prev.val){
            TreeNode temp = new TreeNode(val);
            prev.left = temp;
        }
        else{
            // System.out.println("Reached Here:" + prev.val);
            TreeNode temp = new TreeNode(val);
            prev.right = temp;
        }
        
        return root;
    }
}