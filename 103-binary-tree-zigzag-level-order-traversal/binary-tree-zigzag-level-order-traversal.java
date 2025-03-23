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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return  ans;

        q.offer(root);

        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sublevel = new LinkedList<Integer>();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll(); // top element

                if (leftToRight) {
                    sublevel.addLast(node.val);
                } else {
                    sublevel.addFirst(node.val);
                }

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            // toggle after every iteration at each level
            leftToRight = !leftToRight;
            ans.add(sublevel);
        }

        return ans;
    }
}