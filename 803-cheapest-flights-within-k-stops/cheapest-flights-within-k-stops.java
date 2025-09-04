class Solution {
    class Pair {
        int price;
        int node;

        public Pair(int price, int node) {
            this.price = price;
            this.node = node;
        }
    }

    class Tuple {
        int stops;
        int price;
        int node;

        public Tuple(int stops, int node, int price) {
            this.stops = stops;
            this.node = node;
            this.price = price;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int V = n;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int[] node : flights) {
            int u = node[0];
            int v = node[1];
            int price = node[2];

            adj.get(u).add(new Pair(price, v));
        }

        Queue<Tuple> pq = new LinkedList<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Tuple(0, src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Tuple t = pq.poll();
            int curNode = t.node;
            int curPrice = t.price;
            int curStops = t.stops;

            // System.out.println("cur node: " + curNode);

            // check that is k exceeded then return -1
            if (curStops > k) {
                break;
            }

            // goto the next node
            for (Pair adjPair : adj.get(curNode)) {
                int adjNode = adjPair.node;
                int adjPrice = adjPair.price;

                if (curPrice + adjPrice < dist[adjNode] && curStops <= k) {
                    dist[adjNode] = curPrice + adjPrice;
                    pq.add(new Tuple(curStops + 1, adjNode, curPrice + adjPrice));
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        //else
        return dist[dst];
    }

    // Approach 1 failed as simple Dijaksta will not work here, we need to prioritize stops the cost of finding the cost;
    // public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    //     ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    //     int V = n;

    //     for(int i = 0; i< V; i++){
    //         adj.add(new ArrayList<Pair>());
    //     }

    //     for(int[] node: flights){
    //         int u = node[0];
    //         int v = node[1];
    //         int price = node[2];

    //        adj.get(u).add(new Pair(price, v, 0));
    //     }

    //     System.out.println("Adj Size" + V);

    //     // adj list is ready
    //     Queue<Pair> pq = new Queue<>((x, y) -> x.price - y.price);
    //     int[] dist = new int[V];
    //     int ans = -1;

    //     pq.add(new Pair(0, src, 0));
    //     dist[src] = 0;

    //     while(!pq.isEmpty()){
    //         Pair p = pq.poll();
    //         int curNode = p.node;
    //         int curPrice = p.price;
    //         int curStops = p.stops;

    //         System.out.println("cur node: " + curNode);

    //         // check that is k exceeded then return -1
    //         // if(k <= 0){
    //         //     ans = curPrice;
    //         // }

    //         if(curStops == k){
    //             break;
    //         }

    //         // goto the next node
    //         for(Pair adjPair: adj.get(curNode)){
    //             int adjPrice = adjPair.price;
    //             int adjNode = adjPair.node;

    //             if(curPrice + adjPrice < dist[adjNode] && curStops <= k){
    //                 pq.add(new Pair(adjPrice, adjNode, curStops + 1));
    //                 dist[adjNode] = curPrice + adjPrice;
    //                 ans = Math.min(ans,  dist[adjNode]);
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //     }

    //     return -1;
    // }
}