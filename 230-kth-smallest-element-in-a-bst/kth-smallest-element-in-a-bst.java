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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        List<Integer> elements = new ArrayList<>();

        traverseTree(root, elements);

        Collections.sort(elements);

        if(k == 0) return elements.get(0);

        return elements.get(k - 1);
    }

    public void traverseTree(TreeNode root, List<Integer> ds){
        if(root == null){
            return;
        }

        ds.add(root.val);
        traverseTree(root.left, ds);
        traverseTree(root.right, ds);
        // ds.remove(ds.size() - 1);
    }
}