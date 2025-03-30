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
    // Please see the notes section for the Approach.

    // Approach-1: find the Node with the target, once you find the node, call a function that returns a list of integers, by treating that target node as the root node, but this approach will not work as the element can have more than two branches.

    // Approach-2: find the distance from the root node, once you get the distance from the root node, that will be helpful for opposite side traverak but there is a demarit, how will be knowing the target node is found on the which side.

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMp = new HashMap<>();
        markParents(root, target, parentMp); //now we have the parent

        //-- After marking the parent node, start the traverasal to know about the distance
        Map<TreeNode, Boolean> visitedMp = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        int distance = 0;
        q.add(target);
        visitedMp.put(target, true);

        while (!q.isEmpty()) {
            int size = q.size();
            
            if (distance == k){
                break;
            }
            
            distance++;

            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();

                if (curNode.left != null && visitedMp.get(curNode.left) == null) {
                    q.add(curNode.left);
                    visitedMp.put(curNode.left, true);
                }

                if (curNode.right != null && visitedMp.get(curNode.right) == null) {
                    q.add(curNode.right);
                    visitedMp.put(curNode.right, true);
                }


                // check for parent
                if(parentMp.get(curNode) != null && visitedMp.get(parentMp.get(curNode)) == null){
                   // find the current Node ka parent, add that parent in the q
                    q.add(parentMp.get(curNode)); 
                    //  visitedMp.put(curNode, true);
                    visitedMp.put(parentMp.get(curNode), true); 
                }

            }
        }

        //put the elements from the queue to the ans of the last visited node in the for loop
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode topNode = q.poll();
            ans.add(topNode.val);
        }

        return ans;
    }

    public void markParents(TreeNode root, TreeNode target, Map<TreeNode, TreeNode> parentMp) {
        // Do the level order traversal, 
        Queue<TreeNode> q = new LinkedList<>();

        //How to store the parent of the root
        // Map< node, parent > parentMp
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                q.add(node.left);
                parentMp.put(node.left, node);
            }
            if (node.right != null) {
                q.add(node.right);
                parentMp.put(node.right, node);
            }
        }
    }

}