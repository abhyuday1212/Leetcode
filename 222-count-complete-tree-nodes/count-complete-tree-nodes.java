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
 
 /*
 Tc: log(n)^2
 Sc: O(n) -> recursion
  */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int leftHt = findLeftHt(root.left);
        int rightHt = findRightHt(root.right);

        if (leftHt == rightHt){
            return ((int) Math.pow(2, leftHt + 1) - 1);
        }
            
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int findLeftHt(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private int findRightHt(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    // Brut:
    // Tc: O(n)
    // Sc: O(n)
    // public int recursivelyTraverse(TreeNode root) {
    //     //inorder traversal
    //     if (root == null) {
    //         return 0;
    //     }

    //     return 1 + recursivelyTraverse(root.left) + recursivelyTraverse(root.right);
    // }
}