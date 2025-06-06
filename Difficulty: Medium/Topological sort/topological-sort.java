//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int x = V;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());

            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                adj.get(edges[i][0]).add(edges[i][1]);
            }

            ArrayList<Integer> res = new Solution().topoSort(V, edges);

            if (check(adj, x, res) == true)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = createAdjList(V, edges);
        
        return topoSortUsingBFS(adj, V);
    }
    
    
    public static ArrayList<Integer> topoSortUsingBFS(ArrayList<ArrayList<Integer>> adj, int V){
        int[] indegree = new int[V];
        ArrayList<Integer> topo = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        // Add the values in indegree
        for(int u = 0; u < V; u++){
            for(int v: adj.get(u)){
                // Visit all vertices v that u points to. (u -> v)
                indegree[v]++;
            }
        }
        
        
        // Step 2: Add all nodes with indegree 0 to the queue
        // after filling the indegree now add the root element and start traversal
        
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            
            for(int cur: adj.get(node)){
                if(indegree[cur] != 0){
                    indegree[cur]--;
                    if(indegree[cur] == 0){
                        q.add(cur);
                   }
                }
                
            }
        }
        
        
        return topo;
    }
    
    // public static ArrayList<Integer> topoSort(int V, int[][] edges) {
    //     ArrayList<ArrayList<Integer>> adj = createAdjList(V, edges);
    //     boolean[] isVisited = new boolean[V];
    //     Stack<Integer> st = new Stack<>();
        
        
    //     for(int i = 0; i < V; i++){
    //         if(!isVisited[i]){
    //             // do a dfs traversal
    //             dfsTraversal(i,st, isVisited, adj);
    //         }
    //     }
        
    //     ArrayList<Integer> list = new ArrayList<>();
        
    //     while(!st.isEmpty()){
    //         list.add(st.peek());
    //         st.pop();
    //     }
        
    //     return list;
    // }
    
    
    
    public static void dfsTraversal(int curNode, Stack<Integer> st, boolean[] isVisited, ArrayList<ArrayList<Integer>> adj){
        isVisited[curNode] = true;
        
        for(int adjElem: adj.get(curNode)){
            if(!isVisited[adjElem]){
                dfsTraversal(adjElem, st, isVisited, adj);
            }
        }
        
        st.push(curNode);
    }
    
    public static ArrayList<ArrayList<Integer>> createAdjList(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        
        return adj;
    }
}
