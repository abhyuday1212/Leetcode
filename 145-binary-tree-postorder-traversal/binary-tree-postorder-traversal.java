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
        // iterative postorder using 1 stack traversal
        return iterativePostorderUsing1Stack(root);
      
        // iterative postorder using 1 stack traversal
        // return iterativePostorder(root);


        // recursive postorder traveral
        // List<Integer> arr = new ArrayList<>();

        // postorder(root, arr);

        // return arr;
    }

    // iterative approach using 1 Stack
    static List<Integer> iterativePostorderUsing1Stack(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();

        List<Integer> postorder = new ArrayList<>();

        if(root == null) return postorder;

        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                // this means you are traversing on the right side now
                TreeNode temp = st.peek();
                temp = temp.right;

                if(temp == null){
                    // now get the elements in the stack as that will show the postorder
                    temp = st.peek();
                    st.pop();

                    postorder.add(temp.val);

                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.peek();
                        st.pop();
                        postorder.add(temp.val); // add the rest of the stack elements to the ans
                    }
                }
                else{
                    curr = temp;
                }

            }
            

        }

        return postorder;
    }


    // iterative approach using 2 Stack
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