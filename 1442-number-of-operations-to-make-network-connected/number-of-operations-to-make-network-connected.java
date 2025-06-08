class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    //constructor
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int V = connections.length;

        // some how if I can count the number of connected nodes
        int freeConnections = 0;
        
        // go through the connection Array and increase the count based on the index
        for(int i = 0; i < V; i++){
            int u = connections[i][0];
            int v = connections[i][1];

            if(ds.findUltimateParent(u) == ds.findUltimateParent(v)){
                freeConnections++;
            }
            else{
                ds.unionBySize(u, v);
            }
        }

        // find how many are connected components
        int count = 0;
        for(int i = 0; i < n; i++){
            if(ds.parent.get(i) == i) count++;
        }

        int ans = count - 1;
        return  freeConnections >= ans ? ans: -1;
    }
}