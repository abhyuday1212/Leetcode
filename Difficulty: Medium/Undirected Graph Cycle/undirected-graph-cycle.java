//{ Driver Code Starts
// Initial Template for Java
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
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    class Pair {
        int curNode;
        int cameFrom;

        public Pair(int curNode, int cameFrom) {
            this.curNode = curNode;
            this.cameFrom = cameFrom;
        }
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // with all the edges, create a adjacency list
        // creating ArrayList of ArrayList where each neighbour will store the vertex
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // add edges to the adj list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        
        boolean[] isVisited = new boolean[V];
    
        // for(int i = 0; i < V; i++){
        //     if(!isVisited[i]){
        //         if(checkCycleUsingBfs(i,isVisited, adj)) return true;
        //     }
        // }
        
        for(int i = 0; i < V; i++){
            if(!isVisited[i]){
                if(checkCycleUsingDfs(i, -1, isVisited, adj)) return true;
            }
        }
        
        return false;
        
    }
    
    public boolean checkCycleUsingDfs(int curNode, int cameFrom, boolean[] isVisited, ArrayList<ArrayList<Integer>> adj){
        isVisited[curNode] = true;
        
        for(int adjNode: adj.get(curNode)){
            if(!isVisited[adjNode]){
                if(checkCycleUsingDfs(adjNode, curNode, isVisited, adj)) return true;
            }
            else if(cameFrom != adjNode){
                return true;
            }
        }
        
        return false;
    }
    
    
    public boolean checkCycleUsingBfs(int src, boolean[] isVisited, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q = new LinkedList<>();
        q.add( new Pair(src, -1));
        
        
        while(!q.isEmpty()){
            Pair curPair = q.poll();
            
            int curNode = curPair.curNode;
            int cameFrom = curPair.cameFrom;
            
            isVisited[curNode] = true;
            
            // do the bfs traversal for the adjancecy list
            for(int adjNode: adj.get(curNode)){
                if(!isVisited[adjNode]){
                    isVisited[adjNode] = true;
                    q.add(new Pair(adjNode, curNode));
                }
                else if(cameFrom != adjNode){
                    // if a adjacentNode is visited and it did not came from the parent node then 
                    return true;
                }
            }
        }
        
        return false;
    }
}