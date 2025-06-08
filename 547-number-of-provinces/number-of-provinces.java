// M-2 : DSU
public class DisjointSet {
    // List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    //constructor
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            // rank.add(0);
            size.add(0);
            parent.add(i);
        }
    }

    // find the ultimate parent of the asked node and also reconstruct the parent to the ultiate nodes for each call which
    // bring down the time complexity to a constant time

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        // do the path compression, whenever you return from the recursive call keep updating the values
        int root = findUltimateParent(parent.get(node));
        parent.set(node, root); // path compression
        return root;
    }

    public void unionBySize(int x, int y) {
        int rootX = findUltimateParent(x);
        int rootY = findUltimateParent(y);

        if (rootX == rootY)
            return;

        if (size.get(rootX) < size.get(rootY)) {
            parent.set(rootX, rootY); // assigning the parent of x = parent of y
            size.set(rootY, size.get(rootX) + size.get(rootY));
        } else {
            parent.set(rootY, rootX);
            size.set(rootX, size.get(rootX) + size.get(rootY));
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int V = isConnected.length;
        DisjointSet ds = new DisjointSet(V);

        // run 2 for loops for updating the ultimate parent element meaning if there is edge between two asjacent nodes
        // DSU will ensure that all cities in the same connected group share the same ultimate parent.
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (isConnected[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (i == ds.parent.get(i)) {
                count++;
            }
        }

        return count;
    }

    // M - 1: Traversal Method : works
    // do any traversal, if the traversal is completed then increase the counter, if all nodes are visited from that node, then the count of the province is 1 or if all nodes are nodes are not visited, got to the unvisited node and start the traversal, keep repeating while all the values of isVisited is not equal to 1. After Visiting all the node, return the global count of whenever you went for traversal
    // public int findCircleNum(int[][] isConnected) {
    //     int V = isConnected.length;

    //     boolean[] visited = new boolean[V];

    //     int count = 0;
    //     for (int i = 0; i < V; i++) {
    //         if (!visited[i]) {
    //             count++;
    //             dfsTraversal(i, visited, isConnected);
    //         }
    //     }

    //     return count;
    // }

    // public static void dfsTraversal(int node, boolean[] visited, int[][] isConnected) {
    //     visited[node] = true;
    //     for (int j = 0; j < isConnected[node].length; j++) {
    //         // if there's a direct connection and j hasn't been visited yet
    //         if (isConnected[node][j] == 1 && !visited[j]) {
    //             dfsTraversal(j, visited, isConnected);
    //         }
    //     }
    // }

}