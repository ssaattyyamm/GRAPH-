class Solution {
    int n, m;
    int inf = Integer.MIN_VALUE /2;
    int dp[][];
    public int maxScore(List<List<Integer>> grid) {
        n = grid.size();
        m = grid.get(0).size();

        int arr[][] = new int[n][m];

        dp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = grid.get(i).get(j);
                dp[i][j] = inf;
            }
        }
        int res = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res = Math.max(res , helper(i , j , arr));
            }
        }

        return res;
    }

    public int helper(int row, int col, int[][] arr) {
        int ans = inf;

        if(dp[row][col] != inf) return dp[row][col];

        if(row == n-1 && col == m-1) return ans;

        for (int i = row + 1; i < n; i++) {
            ans = Math.max(ans ,arr[i][col] - arr[row][col] );
            ans = Math.max(ans, arr[i][col] - arr[row][col] + helper(i, col, arr));
        }

        for(int i=col + 1;i<m;i++){
            ans = Math.max(ans , arr[row][i] - arr[row][col]);
            ans = Math.max(ans , arr[row][i] - arr[row][col] + helper(row , i , arr));
        }

        // 0,0 => 0,2 
        // 0 , 0  0 , 1 0,2 == 0 , 1 - 0,0  + 0,2 - 0,1
        return dp[row][col] =  ans;
    }
}