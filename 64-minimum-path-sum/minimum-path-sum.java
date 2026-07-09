class Solution {
    int n, m;
    public int minPathSum(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int dp[][] = new int[n][m];

        dp[n-1][m-1] = grid[n-1][m-1];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i == n-1 && j == m-1) continue;

                int right = Integer.MAX_VALUE/2;
                int bottom = Integer.MAX_VALUE/2;
                if(i + 1 < n){
                    right = grid[i][j] +dp[i+1][j];
                }
                if(j + 1 < m){
                    bottom = grid[i][j] + dp[i][j+1];
                }

                dp[i][j] =  Math.min(right , bottom);
            }
        }
        return dp[0][0];
    }
    public int helper(int row, int col, int[][] grid) {
        if (row >= n || col >= m)
            return Integer.MAX_VALUE / 2;

        if (row == n - 1 && col == m - 1)
            return grid[row][col];

        int bottom = grid[row][col] + helper(row + 1, col, grid);
        int right = grid[row][col] + helper(row, col + 1, grid);

        return Math.min(right, bottom);
    }
}