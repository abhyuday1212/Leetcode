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
    public void flatten(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        dfs(root, nodes);

        for (int i = 0; i < nodes.size(); i++) {
            TreeNode current = nodes.get(i);
            current.left = null;

            if(i == nodes.size() - 1){
                // if the node is last node then point it to null
                current.right = null;
            }
            else{
                // for rest, just point it to immediate after
                current.right = nodes.get(i + 1);
            } 
            
        }
    }

    // preorder
     private void dfs(TreeNode root, List<TreeNode> ds) {
        if (root == null) {
            // ds.add(null);
            return;
        }

        // Add the elements to a list ds
        ds.add(root);

        dfs(root.left, ds);
        dfs(root.right, ds);
    }
}