/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Pair{
    int colVal;
    Node node;
    
    public Pair(int colVal, Node node){
        this.colVal = colVal;
        this.node = node;
    }
}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(0, root));
        
        while(!q.isEmpty()){
            Pair curPair = q.poll();
            int colVal = curPair.colVal;
            Node curNode = curPair.node;
            
            mp.put(colVal, curNode.data);
            
            if(curNode.left != null) q.offer(new Pair(colVal - 1, curNode.left));
            if(curNode.right != null) q.offer(new Pair(colVal + 1, curNode.right));
        }
        
        for(int index: mp.keySet()){
            ans.add(mp.get(index));
        }
        
        return ans;
    }
}