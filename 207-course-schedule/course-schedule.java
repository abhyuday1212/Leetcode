class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;

        ArrayList<ArrayList<Integer>> adjList = createAdjList(V, prerequisites);

        if (isCycleUsingBFS(V, adjList)) {
            return false;
        }

        return true;
    }

    public ArrayList<ArrayList<Integer>> createAdjList(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        return adj;
    }

    // kahn's algo
    public boolean isCycleUsingBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        // indegree calculation

        int[] indegree = new int[V];

        //calculate indegree for each vertices
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        // calculate which indegree is 0, to put it in the q
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // now you have the node, make a topo list for knowing the size or you can simply count the number
        int topoListSize = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            topoListSize++;

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        boolean ans = topoListSize < V ? true : false;

        return ans;
    }
}