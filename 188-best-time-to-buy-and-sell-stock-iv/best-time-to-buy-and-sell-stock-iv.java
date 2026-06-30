class Solution {
    public int maxProfit(int p, int[] prices) {

        int n = prices.length;

        int dp[][][] = new int[n + 1][2][p + 1];

        for (int j = 0; j < 2; j++) {
            for (int k = 0; k <= p; k++) {
                dp[n][j][k] = 0;
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j][0] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= p; k++) {
                    if (j == 1) {
                        dp[i][j][k] = Math.max(-1 * prices[i] + dp[i + 1][0][k], dp[i + 1][1][k]);
                    } else {
                        dp[i][j][k] = Math.max(prices[i] + dp[i + 1][1][k - 1], dp[i + 1][0][k]);
                    }
                }
            }
        }
        return dp[0][1][p];
    }
}