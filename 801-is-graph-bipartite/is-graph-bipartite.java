class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];

        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                // then do the bfsTraversal
                if (!bfsTraversal(i, V,color, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfsTraversal(int start, int V, int[] color, int[][] adj) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int curNode = q.poll();

            // traverse the adjacent nodes direction
            for (int adjElems : adj[curNode]) {
                if (color[adjElems] == -1) {
                    color[adjElems] = 1 - color[curNode];
                    q.add(adjElems);
                } else if (color[adjElems] == color[curNode]) {
                    return false;
                }
            }
        }

        return true;
    }
}