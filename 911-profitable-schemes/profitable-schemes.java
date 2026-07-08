class Solution {
    int MOD = 1000000007;
    public int profitableSchemes(int n, int min, int[] wt, int[] val) {
        int len = wt.length;

        int dp[][][] = new int[len+1][n+1][min+1];

        for(int i=0;i<len+1;i++){
            for(int j=0;j<n+1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }


       
        return helper(n,min,wt,val,len,dp);
    }
    public int helper(int n ,int min,int[] wt,int[] val,int idx,int[][][] dp){

        //base case

        if(idx ==0){
            return min == 0 ? 1 : 0;
        }    

        if(dp[idx][n][min]!= -1) return dp[idx][n][min];
   



        int pick = 0;

        if(n>=wt[idx-1]){
            int curr = Math.max(0,min-val[idx-1]);
            pick = helper(n-wt[idx-1],curr,wt,val,idx-1,dp);
        }

        int skip = helper(n,min,wt,val,idx-1,dp);


        return dp[idx][n][min] = (pick  + skip) % MOD;


   }


}