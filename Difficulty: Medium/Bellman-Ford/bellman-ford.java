// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        // start relaxation for exactly V-1 edges
        for(int i = 0; i < V - 1; i++){
            for(int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                
                if(dist[u] != Integer.MAX_VALUE && (long)dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
                
            }
        }
        
        // do the Nth relaxation to check if a negative cycle exist;
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            if(dist[u] != Integer.MAX_VALUE && (long)dist[u] + wt < dist[v]){
                // since one more relaxation is possible then you can simply return
                return new int[]{-1};
            }
        }
        
        for(int i = 0; i < V; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = 100000000;
            }
        }
        
        return dist;
    }
}
