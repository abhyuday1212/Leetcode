/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution{
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        return recursiveHelper(root, new ArrayList<>());
    }
    
    public static ArrayList<ArrayList<Integer>> recursiveHelper(Node root, ArrayList<Integer> ds){
        ArrayList<ArrayList<Integer>> baseAns = new ArrayList<>();
        
        if (root == null) {
            return baseAns;
        }
        
        ds.add(root.data);
        
        if(root.left == null && root.right == null){
            baseAns.add(new ArrayList<>(ds));
        }
        else{
            baseAns.addAll(recursiveHelper(root.left, ds));
            baseAns.addAll(recursiveHelper(root.right, ds));
        }
        
        ds.remove(ds.size() - 1);
        return baseAns;
    }
}


// class Solution {
//     public static ArrayList<ArrayList<Integer>> Paths(Node root) {
//         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//         ArrayList<Integer> ds = new ArrayList<>();
        
//         getAllPath(root, ans, ds);
        
//         return ans;
//     }
    
//     public static void getAllPath(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds){
//         if(root.left == null && root.right == null){
//             ds.add(root.data);
//             ans.add(new ArrayList<>(ds));
//             // System.out.println("Ans: " + ans);
//             // ds.remove(ds.size() - 1);
//             return;
//         }
        
//         ds.add(root.data);
        
//         getAllPath(root.left, ans, ds);
//         ds.remove(ds.size() - 1);
        
//         getAllPath(root.right, ans, ds);
//         ds.remove(ds.size() - 1);
//     }
// }

