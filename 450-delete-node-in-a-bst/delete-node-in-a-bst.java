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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode current = root;

        // Find the node to be deleted
        while (current != null && current.val != key) {
            parent = current;
            if (key < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // If the key was not found, return the original root.
        if (current == null) {
            return root;
        }

        // Case when the node to delete has two children
        if (current.left != null && current.right != null) {
            // Find the in-order successor (smallest in the right subtree)
            TreeNode successorParent = current;
            TreeNode successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Copy the successor's value to the current node
            current.val = successor.val;

            // Now prepare to delete the successor node instead
            parent = successorParent;
            current = successor;
        }

        // At this point, current has at most one child.
        TreeNode child = (current.left != null) ? current.left : current.right;

        // If the node to be deleted is the root
        if (parent == null) {
            return child;
        }

        // Attach the child to the proper parent pointer
        if (parent.left == current) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        return root;
    }
}