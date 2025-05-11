//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // Always create adjList from the given edges
        ArrayList<ArrayList<Integer>> adjList = createAdjList(V, edges);
        
        boolean[] isVisited = new boolean[V];
        boolean[] isPathVisited = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!isVisited[i]){
                if(checkCycleUsingDfs(i, isVisited, isPathVisited, adjList)){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    public ArrayList<ArrayList<Integer>> createAdjList(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            
            // not for directed graph
            // adj.get(v).add(u);
        }
        
        return adj;
    }
    
    public boolean checkCycleUsingDfs(int curNode, boolean[] isVisited, boolean[] isPathVisited, ArrayList<ArrayList<Integer>> adj){
        isVisited[curNode] = true;
        isPathVisited[curNode] = true;
    
        
        for(int adjNode: adj.get(curNode)){
            if(!isVisited[adjNode]){
                if(checkCycleUsingDfs(adjNode, isVisited, isPathVisited, adj)){
                    return true;
                }
            }
            else if(isVisited[adjNode] && isPathVisited[adjNode]){
                return true;
            }
        }
        
        isPathVisited[curNode] = false;
        return false;
    }
}