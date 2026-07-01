class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0;
        int r = 0;

        int n = Math.min(g.length , s.length);

        while(l < g.length && r < s.length){
            if(g[l] <= s[r]){
                l++;
                r++;
            }
            else{
                r++;
            }
        }
        return l;
    }
}