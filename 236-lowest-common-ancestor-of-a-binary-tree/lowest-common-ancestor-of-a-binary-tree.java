/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        boolean found1 = findPath(root, path1, p);

        ArrayList<TreeNode> path2 = new ArrayList<>();
        boolean found2 = findPath(root, path2, q);

        return findLCS(path1, path2);
    }

    
    public TreeNode findLCS(ArrayList<TreeNode> path1, ArrayList<TreeNode> path2) {
        int lowestSize = path1.size() > path2.size() ? path2.size() : path1.size();


        int index = 0;
        TreeNode firstOrCommonIndex = path1.size() > path2.size() ? path2.getFirst() : path1.getFirst();

        while (index < lowestSize) {
            if (path1.get(index).val == path2.get(index).val) {
                firstOrCommonIndex = path1.get(index);
            }
            index++;
        }

        return firstOrCommonIndex;
    }

    public boolean findPath(TreeNode root, ArrayList<TreeNode> ds, TreeNode key) {
        if (root == null) {
            return false;
        }

        ds.add(root);

        if (root.val == key.val) {
            return true; // Path found
        }

        if (findPath(root.left, ds, key) || findPath(root.right, ds, key)) {
            return true;
        }

        ds.remove(ds.size() - 1);

        return false;
    }
}