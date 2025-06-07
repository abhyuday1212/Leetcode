class Solution {
    class Pair{
        int wt;
        int node;
        
        public Pair(int wt, int node){
            this.wt = wt;
            this.node = node;
        }
    }
    
    public int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        boolean[] isVisited = new boolean[V];
        
        pq.offer(new Pair(0, 0));
        int sum = 0;
        
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int wt = current.wt;
            int node = current.node;
            
            if(isVisited[node]){
                continue;
            }
            
            isVisited[node] = true;
            sum += wt;
            
            for(int[] adjElem: adj.get(node)){
                // System.out.println("Ans: " + adj.get(node));
                int adjNode = adjElem[0];
                int adjWt = adjElem[1];
                
                if(!isVisited[adjNode]){
                    pq.add(new Pair(adjWt, adjNode));
                }
            }
        }
        
        return sum; 
    }
}