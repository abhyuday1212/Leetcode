//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String[] input = br.readLine().trim().split(" ");
                ArrayList<Integer> node = new ArrayList<>();
                for (String s : input) {
                    if (!s.isEmpty()) {
                        node.add(Integer.parseInt(s));
                    }
                }
                adj.add(node);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        
        ArrayList<Integer> bfs = new ArrayList<>();
        visited[0] = true;
        
        dfsTraversal(0, visited, bfs, adj);
        
        return bfs;
    }
    
    public static void dfsTraversal(Integer node,boolean[] visited, ArrayList<Integer> bfs, ArrayList<ArrayList<Integer>> adj){
        bfs.add(node);
        visited[node] = true;
        
        for(Integer currElemInAdjList: adj.get(node)){
            if(visited[currElemInAdjList] == false){
                dfsTraversal(currElemInAdjList, visited, bfs, adj);
            }
        }
    }
}