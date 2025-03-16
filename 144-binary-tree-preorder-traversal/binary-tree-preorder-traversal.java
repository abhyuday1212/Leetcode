/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();

        iterativePreorder(root, arr);

        return arr;
    }

    // iterative approach
    static List<Integer> iterativePreorder(TreeNode root, List<Integer> ans) {
        // root, left, right
        if (root == null)
            return ans;

        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);

        while (!st.isEmpty()) {
            root = st.pop();
            ans.add(root.val);

            if (root.right != null)
                st.push(root.right);

            if (root.left != null)
                st.push(root.left);
        }

        return ans;
    }

    static void preorder(TreeNode root, List<Integer> arr) {
        // base condition
        if (root == null) {
            return;
        }
        // Push the current node's value into the list
        arr.add(root.val);

        preorder(root.left, arr);

        preorder(root.right, arr);
    }

}