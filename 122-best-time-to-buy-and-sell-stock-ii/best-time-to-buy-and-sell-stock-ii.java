class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        int n = prices.length;

        dp = new int[n+1][2];

        for(int d[] : dp){
            Arrays.fill(d , -1);
        }

        return helper(0 , 1 , prices);
    }
    public int helper(int idx , int buy , int [] prices){
        if(idx == prices.length) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];

        int profit = 0;

        if(buy == 1){
           profit = Math.max(-1 * prices[idx] + helper(idx + 1, 0 , prices) , helper(idx + 1 , 1 , prices));
        }
        else{
            profit = Math.max(prices[idx] + helper(idx +1 , 1 , prices) , helper(idx + 1 , 0 , prices));
        }

        return dp[idx][buy] =  profit;
    }
}