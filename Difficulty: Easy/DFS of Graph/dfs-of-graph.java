class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[adj.size()];
        isVisited[0] = true;
        
        ArrayList<Integer> ansList = new ArrayList<>();
        dfsTraversal(0, isVisited, ansList, adj);
        
        return ansList;
    }
    
    public static void dfsTraversal(Integer node, boolean[] isVisited, ArrayList<Integer> ansList, ArrayList<ArrayList<Integer>> adj){
        ansList.add(node);
        isVisited[node] = true;
        
        for(Integer everyNode:adj.get(node)){
            if(!isVisited[everyNode]){
                dfsTraversal(everyNode, isVisited, ansList, adj);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}






















