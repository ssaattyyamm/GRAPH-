class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,t,s,dp);
    }
    public int helper(int idx , int x , String t , String s , int[][] dp ){
        // pruning 
        if(x == t.length()){
            return 1;
        }
        // base case 
        if(idx == s.length()){
            return 0;
        }
        if(dp[idx][x]!= -1 ) return dp[idx][x];

        int ans = helper(idx +1 , x, t,s,dp);

        if(s.charAt(idx) == t.charAt(x)){
            ans += helper(idx + 1,x + 1,t,s,dp);
        }

        return dp[idx][x] =  ans;
    }
}