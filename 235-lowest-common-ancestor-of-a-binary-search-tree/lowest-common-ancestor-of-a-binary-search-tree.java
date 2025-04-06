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
        List<TreeNode> path1 = new ArrayList<>();
        boolean found1 = findPath(root, p, path1);
        
        System.out.println("Printing for Q:");
        List<TreeNode> path2 = new ArrayList<>();
        boolean found2 = findPath(root, q, path2);

        //now findLCA
        return findLCA(path1, path2);
    }

    public TreeNode findLCA(List<TreeNode> l1, List<TreeNode> l2){
        int size = l1.size() < l2.size() ? l1.size() : l2.size();

        TreeNode ans = l1.size() < l2.size() ? l1.get(0) : l2.get(0)  ;
        for(int i = 0; i < size; i++){
            if(l1.get(i).val == l2.get(i).val){
                ans = l1.get(i);
            }
        }

        return ans;
    }

    public boolean findPath(TreeNode root, TreeNode key, List<TreeNode> ds){
        if(root == null ){
            return false;
        }

        System.out.println(root.val);
        ds.add(root);

        if(root.val == key.val){
            return true;
        }

        if (findPath(root.left, key, ds) || findPath(root.right, key, ds)) {
            return true;
        }

        ds.remove(ds.size() - 1);

        return false;
    }
}