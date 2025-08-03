/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public static int findMax(Node root) {
        int maxAns = root.data;
        
        while(root != null){
            if(maxAns < root.data){
                maxAns = root.data;
            }
            root = root.right;
        }
        
        return maxAns;
    }

    public static int findMin(Node root) {
        int minAns = root.data;
        
        while(root != null){
            if(minAns > root.data){
                minAns = root.data;
            }
            root = root.left;
        }
        
        return minAns;
    }
}