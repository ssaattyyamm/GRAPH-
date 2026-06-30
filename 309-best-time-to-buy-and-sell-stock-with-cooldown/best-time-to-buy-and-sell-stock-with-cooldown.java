class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dp[][] = new int[n+2][2];

        for(int i = n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j == 1){
                    dp[i][j] = Math.max(-1 * prices[i] + dp[i+1][0] , dp[i+1][1]);
                }
                else{
                    dp[i][j] = Math.max(prices[i] + dp[i+2][1] , dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
    public int helper(int idx , int buy , int[] prices){
        if(idx >= prices.length) return 0;

        int profit = 0;

        if(buy == 1){
            profit = Math.max(-1 * prices[idx] + helper(idx +1 , 0 , prices) , helper(idx +1 , 1 , prices));
        }
        else{
            profit = Math.max(prices[idx] + helper(idx + 2 ,1 , prices) , helper(idx + 1 , 0 , prices));
        }

        return profit;
    }
}