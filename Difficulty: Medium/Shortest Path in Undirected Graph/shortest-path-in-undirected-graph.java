
class Solution {
    class Pair{
        int dist;
        int node;
        
        public Pair(int dist, int node){
            this.dist = dist;
            this.node = node;
        }
    }
    
    // Method 1: Dijakstra algorithm : Got TLE with this approach
    // public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
    //     PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
    //     int V = adj.size();
        
    //     int[] dist = new int[V];
    //     int[] parent = new int[V];
        
        
    //     Arrays.fill(dist, Integer.MAX_VALUE);
        
    //     pq.add(new Pair(0, src));
        
    //     dist[src] = 0;
        
    //     while(!pq.isEmpty()){
    //         Pair p = pq.poll();
            
    //         int curNode = p.node;
    //         int curDist = p.dist;
            
    //         // go to the nextt node
    //         for(int adjNode: adj.get(curNode)){
    //             if(curDist + 1 < dist[adjNode]){
    //                 dist[adjNode] = curDist + 1;
    //                 pq.offer(new Pair(dist[adjNode], adjNode));
    //             }
    //         }
    //     }
        
    //     for(int i = 0; i < V; i++){
    //         if(dist[i] == Integer.MAX_VALUE){
    //             dist[i] = -1;
    //         }
    //     }
        
    //     return dist;
    // }
    
    //Method- 2
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
