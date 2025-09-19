class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // int INF = 10_00_00_000; //10^8
        int INF = Integer.MAX_VALUE;
        int[][] dist = new int[n][n];

        for (int[] arr : dist) {
            Arrays.fill(arr, INF);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // here k is the via path
                    if (dist[i][k] == INF || dist[k][j] == INF) {
                        continue;
                    }

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int minCount = n;
        int maxNode = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= minCount) {
                minCount = count;
                maxNode = i;
            }
        }

        return maxNode;
    }
}