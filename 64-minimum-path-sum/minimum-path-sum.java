class Solution {
    int dp[][];
    public int minPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        dp = new int[m][n];

        for(int d[] : dp){
            Arrays.fill(d , -1);
        }

        return helper(0 , 0 , m , n , arr);
    }
    public int helper(int row , int col , int m , int n ,int[][] arr){
        if(row == m-1 && col == n-1) return arr[row][col];

        if(row < 0 || row >=m || col < 0 || col >=n) return Integer.MAX_VALUE;

        if(dp[row][col] != -1) return dp[row][col];

        int right = helper(row , col +1 , m , n ,arr);

        int down = helper(row +1 , col , m , n , arr);

        return  dp[row][col] = arr[row][col] + Math.min(right , down);
    }
}