class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i <= n; i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUltimateParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int root = findUltimateParent(parent.get(node));
        parent.set(node, root);
        return root;
    }

    public boolean unionByRank(int x, int y){
        int rootX = findUltimateParent(x);
        int rootY = findUltimateParent(y);

        if(rootX == rootY) return false;

        if(rank.get(rootX) < rank.get(rootY)){
            parent.set(rootX, rootY);
        }
        else if(rank.get(rootX) > rank.get(rootY)){
            parent.set(rootY, rootX);
        }
        else{
            parent.set(rootY, rootX);
            int rankX = rank.get(rootX);
            rank.set(rootX, rankX + 1);
        }

        return true;
    }

}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n + 1);

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];

            if(!ds.unionByRank(u, v)){
                return e;
            }
        }

        return new int[]{0};
    }
}