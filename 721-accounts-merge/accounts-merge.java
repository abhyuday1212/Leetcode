
public class DisjointSet {
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

    public void unionByRank(int x, int y) {
        int rootX = findUltimateParent(x);
        int rootY = findUltimateParent(y);

        if (rootX == rootY)
            return;

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

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mp = new HashMap<>();

        // S-1: Assign the numbers to the mails
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mp.containsKey(mail)) {
                    mp.put(mail, i);
                } else {
                    // since the mail already exist in the database so you can simply map it with the existing parent node
                    ds.unionBySize(i, mp.get(mail));
                }
            }
        }

        // S-2: Merge the mail
        // Initialize an array of ArrayLists. Each index represents an 
        // original account index,
        // and its list will store the emails belonging to its ultimate parent.
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<String>();
        }

        // Iterate through the map of emails to their original account indices.
        // For each email, find the ultimate parent of its original account.
        // Then, add the email to the list corresponding to that ultimate parent.
        for (Map.Entry<String, Integer> it : mp.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUltimateParent(it.getValue());
            mergedMail[node].add(mail);
        }

        // S-3: Find the final sorted answer after merging
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0)
                continue;

            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // add name

            // add the mergedList emails
            for (String it : mergedMail[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }

        return ans;
    }
}