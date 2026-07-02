class Solution {
    int n, m;
    int dp[][];
    public int minDistance(String s, String t) {
        n = s.length();
        m = t.length();

        dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i] , -1);
        }
        return helper(s, t, n, m);
    }

    public int helper(String s, String t, int i, int j) {
        if (i != 0 && j == 0)
            return i;

        if (i == 0 && j != 0)
            return j;

        if (i == 0 && j == 0)
            return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            return dp[i][j] =  helper(s, t, i - 1, j - 1);

        } else {
            int insert = 1 + helper(s, t, i, j - 1);
            int remove = 1 + helper(s, t, i - 1, j);
            int replace = 1 + helper(s, t, i - 1, j - 1);

            return dp[i][j] = Math.min(insert, Math.min(remove, replace));
        }

    }
}