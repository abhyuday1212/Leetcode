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
     public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
     }

     public boolean helper(TreeNode root, long minVal, long maxVal){
        if(root == null) return true;

        if(root.val >= maxVal || root.val <= minVal) return false;

        return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
     }

    //BRUT: Error this code is not checking for the binary tree
    // public boolean isValidBST(TreeNode root) {
    //     if(root == null){
    //         return true;
    //     }

    //     //check for BST
    //     if(root.left != null && root.right != null){
    //         if(root. val > root.left.val && root.val < root.right.val){
    //             return true;
    //         }
    //         else{
    //             return false;
    //         }

    //     }
    //     else if(root.left != null && root.right == null){
    //         if(root. val > root.left.val){
    //             return true;
    //         }
    //         else{
    //             return false;
    //         }
    //     }
    //     else if(root.left == null && root.right != null){
    //         if(root.val < root.right.val){
    //             return true;
    //         }
    //         else{
    //             return false;
    //         }
    //     }


    //     if(isValidBST(root.left) || isValidBST(root.right)){
    //         return true;
    //     }

    //     return false;
    // }
}