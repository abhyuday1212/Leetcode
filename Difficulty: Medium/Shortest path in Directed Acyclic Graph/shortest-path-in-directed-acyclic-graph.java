//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    class Pair{
        int node;
        int weight;
        
        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
      // Step: 1 =>  create adj edges
      ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
      
      for(int i = 0; i < V; i++){
          adj.add(new ArrayList<Pair>());
      }
      
      for(int[] node: edges){
          int u = node[0];
          int v = node[1];
          int wt = node[2];
          
          adj.get(u).add(new Pair(v, wt));
      }
      
      // Step: 2 => Find the topo sort
      boolean[] isVisited = new boolean[V];
      
      Stack<Integer> st = new Stack<>();
      
      for(int i = 0 ; i < V; i++){
          if(!isVisited[i]){
              topoSortByDfs(i, adj, isVisited, st);
          }
      }
      
      int[] dist = new int[V];
      
      Arrays.fill(dist, Integer.MAX_VALUE);
      
      dist[0] = 0; // src ndoe to start the traversal is 0
      
      while(!st.isEmpty()){
          int curNode = st.pop();
        //   st.pop();
          
            if(dist[curNode] != Integer.MAX_VALUE) {
                for(Pair p : adj.get(curNode)) {
                    int v = p.node;
                    int weight = p.weight;
                        
                    // Check to avoid integer overflow
                    if(dist[curNode] != Integer.MAX_VALUE && 
                        dist[curNode] + weight < dist[v]) {
                        dist[v] = dist[curNode] + weight;
                    }
                }
            }
      }
      
      for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
       }

      return dist;
      
    }
    
    public void topoSortByDfs(int curNode, ArrayList<ArrayList<Pair>> adj, boolean[] isVisited, Stack<Integer> st){
        isVisited[curNode] = true;
        
        for(int i = 0; i < adj.get(curNode).size(); i++){
            int adjNode = adj.get(curNode).get(i).node;
            
            if(!isVisited[adjNode]){
                topoSortByDfs(adjNode, adj, isVisited, st);
            }
        }
        
        st.push(curNode);
    }
}