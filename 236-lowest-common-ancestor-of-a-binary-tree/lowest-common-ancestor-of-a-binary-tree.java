/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Recursion
// When you figure out that the particular node exist and is not null then if both left and right paths gets the value then then it can be said the element to receive the not null value first from both the sides will be the rootnode
// TC: O(n)
// SC: O(n)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root; // this is the LCS
        }

        return left != null ? left : right;
    }
}

// BRUT
/*
class Solution {
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null){
           return root;
       }

       List<TreeNode> pathP = new ArrayList<>();
       List<TreeNode> pathQ = new ArrayList<>();

       if(findPath(root, p, pathP) &&  findPath(root, q, pathQ)){
           return findLCS(root, pathP, pathQ, p.val, q.val);
       }

       return null;
   }

   public TreeNode findLCS(TreeNode root, List<TreeNode> path1, List<TreeNode> path2, int p, int q){
       TreeNode lastCommonNode = root;

       int left = 0, right = 0;

       while(left < path1.size() && right < path2.size()){
           if(path1.get(left).val == p && path2.get(right).val == q){
               return lastCommonNode;
           }

           if(path1.get(left) == path2.get(right)){
               lastCommonNode = path1.get(left);
           }
           left++;
           right++;
       }

       return lastCommonNode;
   }

   public boolean findPath(TreeNode root, TreeNode node, List<TreeNode> ds){
       if(root == null){
           return false;
       }

       ds.add(root);

       if(root.val == node.val || root.val == node.val){
           return true;
       }

       if(findPath(root.left, node, ds) || findPath(root.right, node, ds)){
           return true;
       }

       ds.remove(ds.size() - 1);

       return false;
   }
}
*/