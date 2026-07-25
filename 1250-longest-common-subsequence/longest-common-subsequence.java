class Solution {
    int dp[][];
    public int longestCommonSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[n+1][m+1];

        for(int i = 1 ; i <= n;i++){
            for(int j = 1 ; j <= m; j++){
                int pick = 0;
                if(s.charAt(i -1 ) == t.charAt(j - 1)){
                    pick = 1 + dp[i-1][j-1];
                }

                int skip = Math.max(dp[i-1][j] ,  dp[i][j-1]);

                dp[i][j] = Math.max(pick , skip);
            }
        }


        return dp[n][m];
    }
    public int helper(String s , String t , int i  , int j){
        if(i == 0 || j == 0) return 0;

        int pick = 0;

        if(s.charAt(i-1) == t.charAt(j-1)){
            pick = 1 + helper(s , t , i-1 , j -1);
        }

        int skip = Math.max(helper(s ,t , i , j -1) , helper(s ,t , i -1 , j));

        return Math.max(pick , skip);
    }
}