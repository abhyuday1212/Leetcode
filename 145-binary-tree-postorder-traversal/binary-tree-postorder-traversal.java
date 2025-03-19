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
    public List<Integer> postorderTraversal(TreeNode root) {
        // iterative postorder traversal
        return iterativePostorder(root);

        // recursive postorder traveral
        // List<Integer> arr = new ArrayList<>();

        // postorder(root, arr);

        // return arr;
    }

    // iterative approach
    static List<Integer> iterativePostorder(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        List<Integer> postorder = new ArrayList<>();

        if(root == null) return postorder;

        st1.push(root);

        while (!st1.isEmpty()) {
            root = st1.pop();

            st2.push(root);

            if (root.left != null) {
                st1.push(root.left);
            }

            if (root.right != null) {
                st1.push(root.right);
            }
        }

        while (!st2.isEmpty()) {
            postorder.add(st2.pop().val);
        }

        return postorder;
    }

    static void postorder(TreeNode root, List<Integer> arr) {
        // base condition
        if (root == null) {
            return;
        }

        postorder(root.left, arr);

        postorder(root.right, arr);

        // Push the current node's value into the list
        arr.add(root.val);
    }
}