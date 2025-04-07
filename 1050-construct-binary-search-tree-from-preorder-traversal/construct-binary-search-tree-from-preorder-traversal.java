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
    // Optimal: TC : O(3n)
    // Sc: O(N)
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[] { 0 }); //passing the 0 indexed array to pass by refference as integer is passed by value only;
    }

    public TreeNode bstFromPreorder(int[] arr, int maxVal, int[] index) {
        if (index[0] >= arr.length || arr[index[0]] > maxVal) {
            return null;
        }

        TreeNode root = new TreeNode(arr[index[0]++]);

        root.left = bstFromPreorder(arr, root.val, index);
        root.right = bstFromPreorder(arr, maxVal, index);

        return root;
    }

    // ------- Error: My approach
    // int index = 1;

    // public TreeNode bstFromPreorder(int[] preorder) {
    //     TreeNode root = new TreeNode(preorder[0]);
    //     // go fill the elements in the array
    //     buildBST(root, preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    //     return root;
    // }

    // public void buildBST(TreeNode root, int[] arr, int minVal, int maxVal) {
    //     if (index >= arr.length) {
    //         return;
    //     }

    //     int curVal = arr[index];

    //     if (curVal < minVal || curVal > maxVal) {
    //         return;
    //     }

    //     TreeNode newNode = new TreeNode(curVal);
    //     index++;

    //     if (curVal < root.val) {
    //         // move left
    //         root.left = newNode;
    //         buildBST(newNode, arr, minVal, root.val);
    //     } else if (curVal > root.val) {
    //         // move right
    //         root.right = newNode;
    //         buildBST(newNode, arr, root.val, maxVal);
    //     }
    // }
}