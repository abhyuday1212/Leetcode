class Solution {
    // do any traversal, if the traversal is completed then increase the counter, if all nodes are visited from that node, then the count of the province is 1 or if all nodes are nodes are not visited, got to the unvisited node and start the traversal, keep repeating while all the values of isVisited is not equal to 1. After Visiting all the node, return the global count of whenever you went for traversal
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;

        boolean[] visited = new boolean[V];

        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfsTraversal(i, visited, isConnected);
            }
        }

        return count;
    }

    public static void dfsTraversal(int node, boolean[] visited, int[][] isConnected) {
        visited[node] = true;
        for (int j = 0; j < isConnected.length; j++) {
            // if there's a direct connection and j hasn't been visited yet
            if (isConnected[node][j] == 1 && !visited[j]) {
                dfsTraversal(j, visited, isConnected);
            }
        }
    }
}