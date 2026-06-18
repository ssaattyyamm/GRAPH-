class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        for(int[] d : dp){
            Arrays.fill(d , -1);
        }

        return helper(0 , 0 , m , n);
    }
    public int helper(int row , int col , int m , int n){
        if(row == m-1 && col == n-1) return 1;

        if(row < 0 || row >= m || col < 0 || col >= n) return 0;

        if(dp[row][col] != -1 ) return dp[row][col];

        int right = helper(row, col +1 , m ,n);

        int down = helper(row +1 , col , m , n);

        return dp[row][col] =  right + down;
    }
}