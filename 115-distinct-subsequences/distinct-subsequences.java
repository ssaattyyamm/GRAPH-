class Solution {
    int n , m ;
    int dp[][];
    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();

        dp = new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i] , -1);
        }

        return helper(s , t, 0 , 0);

    }
    public int helper(String s , String t , int i , int j){
        if(j == m) return 1;
        if(i == n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;

        if(s.charAt(i) == t.charAt(j)){
            ans += helper(s , t, i +1 ,j +1);
        }
    
        ans+= helper(s , t, i + 1 , j);
        
        return dp[i][j] =  ans;
    }
}