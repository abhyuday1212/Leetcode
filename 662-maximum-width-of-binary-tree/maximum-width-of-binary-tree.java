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

/*
Zero Based - Indexing
1st Elem = 2 * i + 1
2nd Elem = 2 * i + 2
 */
class Solution {
    Map<Integer, Integer> firstDepthIndex = new HashMap<>();
    // depth, index

    int maxWidth = 0;

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        // root, dept, index
        return maxWidth;
    }

    public void dfs(TreeNode root, int depth, long index) {
        if (root == null) {
            return;
        }

        // if at this depth, map doesnt contains the index then only store the depth at this level
        if (!firstDepthIndex.containsKey(depth)) {
            firstDepthIndex.put(depth, (int) index);
        }

        int firstIndex = firstDepthIndex.get(depth);
        int curWidth = (int) index - firstIndex + 1;
        maxWidth = Math.max(maxWidth, curWidth);

        dfs(root.left, depth + 1, 2 * index + 1);
        dfs(root.right, depth + 1, 2 * index + 2);
    }
}

/*
1-based indexing
1st Elem = 2 * i
2nd Elem = 2 * i + 1
 */
// class Solution {
//     Map<Integer, Integer> firstDepthIndex = new HashMap<>();
//     // depth, index

//     int maxWidth = 0;

//     public int widthOfBinaryTree(TreeNode root) {
//         dfs(root, 0, 1);
//         // root, dept, index
//         return maxWidth;
//     }

//     public void dfs(TreeNode root, int depth, long index){
//         if(root == null){
//             return;
//         }

//         // if at this depth, map doesnt contains the index then only store the depth at this level
//         if(!firstDepthIndex.containsKey(depth)){
//             firstDepthIndex.put(depth, (int)index);
//         }

//         int firstIndex = firstDepthIndex.get(depth);
//         int curWidth = (int)index - firstIndex + 1;
//         maxWidth = Math.max(maxWidth, curWidth);

//         dfs(root.left, depth + 1, 2*index);
//         dfs(root.right, depth + 1, 2*index + 1);
//     }
// }