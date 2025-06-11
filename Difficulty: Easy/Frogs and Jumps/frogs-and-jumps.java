// User function Template for Java

class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        boolean[] visited = new boolean[leaves + 1];
        HashSet<Integer> seenJumps = new HashSet<>();
        
        for(int i = 0; i < N; i++){
            int jump = frogs[i];
            if (jump <= 0 || seenJumps.contains(jump)) continue;
            seenJumps.add(jump);
            
            // try the frog 0
            helper(leaves, jump, jump, visited);
        }
        
        int count = 0;
        
        for(int i = 1; i <= leaves; i++){
            if(!visited[i]) count++;
        }
        
        return count;
    }
    
    public void helper(int leaves, int j, int i, boolean[] visited){
        if(leaves < i){
            return;
        }
        
        visited[i] = true;
        helper(leaves, j, i + j, visited);
    }
}
