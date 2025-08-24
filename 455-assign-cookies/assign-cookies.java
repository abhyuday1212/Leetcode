class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0; // cookie
        int n1 = s.length;

        int r = 0; // kids
        int n2 = g.length;

        while(l < n1 && r < n2){
            if(s[l] >= g[r]){
                r++;
            }
            
            l++;
        }

        return r;
    }
}