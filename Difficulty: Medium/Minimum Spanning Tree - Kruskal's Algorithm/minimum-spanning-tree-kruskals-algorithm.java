class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    //constructor
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
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

        if (rootX == rootY) return;

        if (size.get(rootX) < size.get(rootY)) {
            parent.set(rootX, rootY); // assigning the parent of x = parent of y
            size.set(rootY, size.get(rootX) + size.get(rootY));
        } else {
            parent.set(rootY, rootX);
            size.set(rootX, size.get(rootX) + size.get(rootY));
        }
    }

    public void unionByRank(int x, int y) {
        int rootX = findUltimateParent(x);
        int rootY = findUltimateParent(y);

        if (rootX == rootY) return;

        if (rank.get(rootX) < rank.get(rootY)) {
            parent.set(rootX, rootY); // assigning the parent of x = parent of y
        } else if (rank.get(rootX) > rank.get(rootY)) {
            parent.set(rootY, rootX);
        } else {
            // since both are equal then you can connect either of X or Y to one another
            parent.set(rootY, rootX);
            int rankX = rank.get(rootX);
            rank.set(rootX, rankX + 1);
        }
    }

}

// User function Template for Java
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        DisjointSet ds = new DisjointSet(V);
        
        // since edges are given, we need to sort the edges based on the wt
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        int mstWt = 0;
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            if(ds.findUltimateParent(u) != ds.findUltimateParent(v)){
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }
        
        return mstWt;
    }
}
