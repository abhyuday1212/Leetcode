
class Solution {
    // Do the BFS traversal
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size();
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<Integer> q = new LinkedList<>();
        
        // src node ko add kro
        dist[src] = 0;
        
        q.add(src);
        
        while(!q.isEmpty()){
            int curNode = q.poll();
            
            // find the next nodes
            for(int nextNode: adj.get(curNode)){
                if(dist[curNode] + 1 < dist[nextNode]){
                    dist[nextNode] = 1 + dist[curNode];
                    q.add(nextNode);
                }
            }
        }
        
        for(int i = 0; i < V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}
