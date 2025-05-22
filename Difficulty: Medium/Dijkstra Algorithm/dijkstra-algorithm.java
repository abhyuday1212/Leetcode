class Solution {
    class Pair{
        int wt;
        int node;
        
        public Pair(int wt, int node){
            this.wt = wt;
            this.node = node;
        }
    }
    
    public int[] dijkstra(int V, int[][] edges, int src) {
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
       
       for(int u = 0; u < V; u++){
           adj.add(new ArrayList<Pair>());
       }
       
       for(int[] edge: edges){
           int u = edge[0];
           int v = edge[1];
           int wt = edge[2];
           
           adj.get(u).add(new Pair(wt, v));
           adj.get(v).add(new Pair(wt, u));
       }
       // list is crerated
       
       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt); //minHeap
       
       int[] dist = new int[V];
       Arrays.fill(dist, Integer.MAX_VALUE);
       
       pq.add(new Pair(0, src));
       dist[src] = 0;
       
       while(!pq.isEmpty()){
           Pair p = pq.poll();
           
           int curNodeWt = p.wt;
           int curNode = p.node;
           
           for(int i = 0; i < adj.get(curNode).size(); i++){
               int adjWt = adj.get(curNode).get(i).wt;
               int adjNode =  adj.get(curNode).get(i).node;
               
               if(curNodeWt + adjWt < dist[adjNode]){
                   dist[adjNode] = curNodeWt + adjWt;
                   pq.offer(new Pair(dist[adjNode], adjNode));
               }
           }
       }
       
       return dist;
        
    }
}