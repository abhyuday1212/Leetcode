class Solution {
    // Reversing the given graph since outdegeee is 0, so after reversal if you get the outdegree as 0 then if you reverse the graph then Kahns algorithm can be applied
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }

        // reverse the list since outdegree is 0, then somehow we need to make it compatible for BFS, and for that we need to reverse the ArrayList, also while reversing do the indegree calculation

        int[] indegree = new int[V];

        for (int u = 0; u < V; u++) {
            // u -> v
            for (int v : graph[u]) {
                // v -> u
                adjRev.get(v).add(u);
                indegree[u]++;
            }
        }

        // Start the Kahns Algorithm BFS traversal
        Queue<Integer> q = new LinkedList<>();

        List<Integer> safeNodes = new ArrayList<>();

        // add the 0 indegree elems to the q
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);

            for (int adjNode : adjRev.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    q.add(adjNode);

                }
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
    }

    // DFS: Method (Gave TLE)
    // public List<Integer> eventualSafeNodes(int[][] graph) {
    //     int V = graph.length;

    //     boolean[] isVisited = new boolean[V];
    //     List<Integer> ans = new ArrayList<>();

    //     for (int i = 0; i < V; i++) {
    //         Arrays.fill(isVisited, false);
    //         if (isTerminalReached(i, isVisited, graph)) {
    //             ans.add(i);
    //         }
    //     }

    //     return ans;
    // }

    // public boolean isTerminalReached(int curNode, boolean[] isVisited, int[][] adj) {
    //     if (adj[curNode].length == 0) {
    //         return true;
    //     }

    //     // cycle detected ⇒ not safe
    //     if (isVisited[curNode]) {
    //         return false;
    //     }

    //     isVisited[curNode] = true;

    //     for (int nextNode : adj[curNode]) {
    //         if (!isTerminalReached(nextNode, isVisited, adj)) {
    //             isVisited[curNode] = false;
    //             return false;
    //         }
    //     }

    //     isVisited[curNode] = false;
    //     return true;
    // }
}