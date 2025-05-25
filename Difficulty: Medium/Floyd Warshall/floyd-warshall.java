// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
         int INF = 100000000; //10^8
        
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    // here k is the via path
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        
        // since does not contain any negative cycle then no need to check for this
        // but what if would contain negative cycle
        // for(int i = 0; i < n; i++){
        //     if(dist[i][i] < 0){
        //         // contain negative cycle
        //     }
        // }
    }
}