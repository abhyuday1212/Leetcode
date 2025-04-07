class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = s.length, l= 0;
        int n = g.length, r = 0;

        Arrays.sort(s);
        Arrays.sort(g);

        int size = m < n ? m : m;
        while(l < size && r < n){
            if(g[r] <= s[l]){
                r = r + 1;
            }
            l = l + 1;
        }

        return r;
    }
}