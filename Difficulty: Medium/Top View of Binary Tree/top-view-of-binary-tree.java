//{ Driver Code Starts
// Initial Template for JAVA

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


// } Driver Code Ends

// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
     class Pair{
        Node node;
        int position;
        
        Pair(Node node, int position){
            this.node = node;
            this.position = position;
        }
    }
    
    
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.

    static ArrayList<Integer> topView(Node root) {
       ArrayList<Integer> ans = new ArrayList<>();
       
       // TreeMap to keep the keys (positions) sorted.
       Map<Integer, Integer> mp = new TreeMap<>();
       
        // Queue for level order traversal; stores Pair (node and its position)
       Queue<Pair> q = new LinkedList<>();
       
       q.add(new Pair(root, 0));
       
       while(!q.isEmpty()){
           Pair curPair = q.poll();
           Node curNode = curPair.node;  // current node
           int pos = curPair.position;
           
            // If a node at this position is not yet added, add it.
           if(!mp.containsKey(pos)){
               mp.put(pos, curNode.data);
           }
           
           // level order things
           if(curNode.left != null){
               q.add(new Pair(curNode.left, pos - 1));
           }
           
           if(curNode.right != null){
               q.add(new Pair(curNode.right, pos + 1));
           }
       }
       
       
       // transfer the elements from the TreeMap to the list
       
       for(int val : mp.values()){
           ans.add(val);
       }
       
       return ans;
    }
}


//{ Driver Code Starts.

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Tree {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();

            ArrayList<Integer> vec = ob.topView(root);
            for (int x : vec) System.out.print(x + " ");
            System.out.println();

            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends