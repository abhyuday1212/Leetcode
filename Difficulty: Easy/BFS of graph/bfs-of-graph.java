class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[adj.size()];
        ArrayList<Integer> bfsList = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0);
        isVisited[0] = true;
        
        while(!q.isEmpty()){
            Integer curNode = q.poll();
            bfsList.add(curNode);
            
            for(int elems:adj.get(curNode)){
                if(!isVisited[elems]){
                    isVisited[elems] = true;
                    q.offer(elems);
                }
            }
        }
        
        return bfsList;
    }
}