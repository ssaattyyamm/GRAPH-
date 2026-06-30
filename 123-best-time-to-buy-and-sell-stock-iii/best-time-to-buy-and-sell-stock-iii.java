class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dp[][][] = new int[n+1][2][3];

        for(int j=0;j<2;j++){
            for(int k= 0;k<3;k++){
                dp[n][j][k] = 0;
            }
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                dp[i][j][0] = 0;
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int k=1;k<3;k++){
                    if(j == 1){
                         dp[i][j][k] =  Math.max(-1 * prices[i] + dp[i+1][0][k] , dp[i+1][1][k]);
                    }
                    else{
                        dp[i][j][k] =  Math.max(prices[i] + dp[i+1][1][k-1] , dp[i+1][0][k]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
    public int helper(int idx , int buy , int cap , int[] prices){
        if(idx == prices.length || cap == 0) return 0;

        int profit = 0;

        if(buy == 1){
            profit =  Math.max(-1 * prices[idx] + helper(idx + 1, 0 , cap ,prices)  , helper(idx + 1, 1 , cap , prices));
        }
        else{
            profit = Math.max(prices[idx] + helper(idx + 1 , 1 , cap-1,prices) , helper(idx +1 , 0 , cap,prices));
        }

        return profit;
    }
}